package ca.udes.ift604.tp1.client;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;

public class UseClient
{
    public static void main(String[] args)
    {

        try
        {
            String ipServer = new String();
            InetAddress ip = Inet4Address.getByName(ipServer);
            ClientUDP client1 = new ClientUDP(ip, 8888, "Ma première requette");
            client1.start();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
