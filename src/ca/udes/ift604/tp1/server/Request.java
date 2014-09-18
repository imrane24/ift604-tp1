package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.tools.Tools;

public class Request implements Runnable
{
    private byte buffer[] = new byte[1024];
    private final DatagramPacket requestPacket;
    private final DatagramSocket serverSocket;

    public Request(DatagramSocket serverSocket, DatagramPacket requestPacket) throws SocketException
    {
        this.requestPacket = requestPacket;
        this.serverSocket = serverSocket;
        System.out.println("Nouvelles requettes");
    }

    @Override
    public void run()
    {
        try
        {
            // Gerer les requetes !
            // System.out.println("Données : "+ new
            // String(requestPacket.getData()));

            Match m1 = (Match) Tools.deserealizer(requestPacket.getData());

            System.out.println("Serveur Dit :");
            System.out.println(m1.toString());

            String msg = new String("Voilà ma réponse ;-) ");
            buffer = msg.getBytes();

            // Reponse au client
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length, requestPacket.getAddress(), requestPacket.getPort());
            serverSocket.send(reply);

        } catch (IOException | ClassNotFoundException e)
        {
            System.err.println("Error Request");
            e.printStackTrace();
        }
    }
}