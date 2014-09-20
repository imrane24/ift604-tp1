package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.match.Team;
import ca.udes.ift604.tp1.tools.Tools;

public class Request implements Runnable
{
    private final DatagramPacket receivePacket;
    private final DatagramSocket serverSocket;

    private static final int size = 1024;
    static byte sendBuffer[] = new byte[size];

    public Request(DatagramSocket serverSocket, DatagramPacket requestPacket) throws SocketException
    {
        this.receivePacket = requestPacket;
        this.serverSocket = serverSocket;
        System.out.println("Nouvelles requettes");
    }

    @Override
    public void run()
    {
        try
        {
            // Reception de la requete du client
            String request = new String(receivePacket.getData());
            System.out.println("La requete du client : " + request);
            // Reponse au client

            Match match1 = new Match(new Date(), new Team("Les Vikings"), new Team("Les Barbares"), "match1");
            match1.team1Goal();
            match1.team1Goal();

            match1.team2Penalty();

            match1.team2Goal();
            match1.team1Goal();
            match1.nextPeriod();

            match1.team2EndPenalty();
            match1.team1Penalty();

            // On envoi le match choisi
            sendBuffer = Tools.serealizer(match1);

            if (request.contains("match1"))
            {
                DatagramPacket replyPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(replyPacket);
            } else
            {
                System.out.println("Pas le match 1");
            }

        } catch (IOException e)
        {
            System.err.println("Error Request");
            e.printStackTrace();
        }
    }
}