package ca.udes.ift604.tp1.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP
{
    private final DatagramSocket clientSocket;
    private InetAddress serverAddress;

    public ClientUDP(InetAddress serverAddress, int port) throws IOException
    {
        clientSocket = new DatagramSocket(port);
        this.serverAddress = serverAddress;
    }

    public void start()
    {
        try
        {
            byte[] msg = new byte[1024];
            // TODO Requete à faire
            DatagramPacket request = new DatagramPacket(msg, msg.length,
                    serverAddress, clientSocket.getPort());

        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            clientSocket.close();
        }
    }
}