package ca.udes.ift604.tp1.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.match.Team;
import ca.udes.ift604.tp1.tools.Tools;

public class ClientUDP
{
    private final DatagramSocket clientSocket;
    private InetAddress serverAddress;
    private int serverPort;
    private static final int size = 1024;

    static byte sendBuffer[] = new byte[size];

    public ClientUDP(InetAddress serverAddress, int serverPort) throws IOException
    {
        clientSocket = new DatagramSocket();
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start()
    {
        try
        {
            System.out.println("Client Start");

            // *************************

            Match match1 = new Match(new Date(), new Team("Les Vikings"), new Team("Les Barbares"));
            match1.team1Goal();
            match1.team1Goal();

            match1.team2Penalty();

            match1.team2Goal();
            match1.team1Goal();
            match1.nextPeriod();

            match1.team2EndPenalty();
            match1.team1Penalty();

            sendBuffer = Tools.serealizer(match1);

            // *************************
            // Requete à faire
            DatagramPacket request = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);

            clientSocket.send(request);

            // Reponse du serveur
            byte[] receiveBuffer = new byte[size];
            DatagramPacket replyServer = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(replyServer);
            System.out.println("Reponse du serveur : " + new String(replyServer.getData()));
        } catch (Exception e)
        {
            System.err.println("Error Client");
            e.printStackTrace();
        } finally
        {
            clientSocket.close();
        }
    }
}