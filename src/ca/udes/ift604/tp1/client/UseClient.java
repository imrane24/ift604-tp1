package ca.udes.ift604.tp1.client;

import java.io.IOException;
import java.net.InetAddress;

public class UseClient
{
    public static void main(String[] args)
    {

        try
        {
            // String ipServer = new String("localhost");
            // InetAddress ip = InetAddress.getByName(ipServer);
            ClientUDP client1 = new ClientUDP(InetAddress.getLocalHost(), 8888);
            client1.start();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
