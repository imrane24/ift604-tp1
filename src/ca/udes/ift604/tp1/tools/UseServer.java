package ca.udes.ift604.tp1.tools;

import java.io.IOException;

import ca.udes.ift604.tp1.server.ServerUDP;

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
