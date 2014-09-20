package ca.udes.ift604.tp1.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import ca.udes.ift604.tp1.match.Match;
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

            // On demande le match
            String s = new String("match1");
            sendBuffer = s.getBytes();
            DatagramPacket request = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, serverPort);

            clientSocket.send(request);

            // Reponse du serveur
            byte[] receiveBuffer = new byte[size];
            DatagramPacket replyPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(replyPacket);

            Match m1 = (Match) Tools.deserealizer(replyPacket.getData());

            System.out.println(m1.toString());

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