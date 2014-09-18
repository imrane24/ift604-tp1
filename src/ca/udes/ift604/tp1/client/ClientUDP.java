package ca.udes.ift604.tp1.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP
{
    private final DatagramSocket clientSocket;
    private InetAddress serverAddress;
    private int serverPort;
    private String msg;
    private static final int size = 1024;

    static byte sendBuffer[] = new byte[size];

    public ClientUDP(InetAddress serverAddress, int serverPort, String msg)
            throws IOException
    {
        clientSocket = new DatagramSocket();
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.msg = msg;
    }

    public void start()
    {
        try
        {
            System.out.println("Client Start");

            sendBuffer = msg.getBytes();
            // Requete à faire
            DatagramPacket request = new DatagramPacket(sendBuffer,
                    sendBuffer.length, serverAddress, serverPort);

            clientSocket.send(request);

            // Reponse du serveur
            byte[] receiveBuffer = new byte[size];
            DatagramPacket replyServer = new DatagramPacket(receiveBuffer,
                    receiveBuffer.length);
            clientSocket.receive(replyServer);
            System.out.println("Reponse du serveur : "
                    + new String(replyServer.getData()));
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