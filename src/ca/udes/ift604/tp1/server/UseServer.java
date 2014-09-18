package ca.udes.ift604.tp1.server;

import java.io.IOException;

public class UseServer
{
    public static void main(String[] args)
    {
        try
        {
            ServerUDP serverUDP = new ServerUDP(8888, 10);
            serverUDP.start();

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
