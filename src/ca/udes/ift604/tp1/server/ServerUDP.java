package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerUDP
{
    private final DatagramSocket serverSocket;
    private final ExecutorService pool;

    public ServerUDP(int port, int poolSize) throws IOException
    {
        serverSocket = new DatagramSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    public void start()
    {
        try
        {
            while (true)
            {
                pool.execute(new Request(serverSocket));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            pool.shutdown();
            serverSocket.close();
        }
    }
}