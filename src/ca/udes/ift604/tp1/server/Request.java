package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Request implements Runnable
{
    final static byte buffer[] = new byte[1024];
    private final DatagramSocket socket;

    public Request(DatagramSocket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            
            // Gerer les requetes !
            
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            socket.close();
        }

    }

}