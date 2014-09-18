package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerUDP
{
    private final DatagramSocket serverSocket;
    private final ExecutorService pool;

    static byte buffer[] = new byte[1024];

    public ServerUDP(int port, int poolSize) throws IOException
    {
        InetAddress local = InetAddress.getLocalHost();
        serverSocket = new DatagramSocket(port, local);

        pool = Executors.newFixedThreadPool(poolSize);

        System.out.println("Mon adress : " + local);
    }

    public void start()
    {
        try
        {
            while (true)
            {
                DatagramPacket requestPacket = new DatagramPacket(buffer,
                        buffer.length);
                serverSocket.receive(requestPacket);
                pool.execute(new Request(serverSocket, requestPacket));
            }

        } catch (Exception e)
        {
            System.err.println("Error Server");
            e.printStackTrace();
        } finally
        {
            pool.shutdown();
            serverSocket.close();
        }
    }
}