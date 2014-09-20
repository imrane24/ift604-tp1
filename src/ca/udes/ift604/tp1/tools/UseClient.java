package ca.udes.ift604.tp1.tools;

import java.io.IOException;
import java.net.InetAddress;

import ca.udes.ift604.tp1.client.ClientUDP;

public class UseClient
{
    public static void main(String[] args)
    {

        try
        {
            InetAddress ip = InetAddress.getByName("192.168.2.21");
            ClientUDP client1 = new ClientUDP(ip, 8888);
            ClientUDP client2 = new ClientUDP(ip, 8888);
            ClientUDP client3 = new ClientUDP(ip, 8888);
            ClientUDP client4 = new ClientUDP(ip, 8888);

            client1.start("update");
            System.out.println(client1.getMatch("match1").toString());

            Thread.sleep(3000);

            client2.start("update");
            System.out.println(client2.getMatch("match5").toString());

            Thread.sleep(3000);

            client3.start("update");
            System.out.println(client3.getMatch("match3").toString());

            Thread.sleep(3000);

            client4.start("update");
            System.out.println(client4.getMatch("match2").toString());

        } catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
