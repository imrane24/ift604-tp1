package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ca.udes.ift604.tp1.match.Match;

public class ServerUDP
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private final DatagramSocket serverSocket;
    private final ExecutorService pool;
    private List<Match> listMatch;

    static byte buffer[] = new byte[1024];

    /*------------------------------------------------------------------*\
    |*                          Constructeurs                           *|
    \*------------------------------------------------------------------*/

    public ServerUDP(int port, int poolSize) throws IOException
    {
        InetAddress local = InetAddress.getLocalHost();
        serverSocket = new DatagramSocket(port, local);
        pool = Executors.newFixedThreadPool(poolSize);

        this.listMatch = new ArrayList<Match>();
        System.out.println("Mon adress : " + local);
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Public                         *|
    \*------------------------------------------------------------------*/

    public void start()
    {
        try
        {
            while (true)
            {
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(requestPacket);
                pool.execute(new Request(serverSocket, requestPacket, listMatch));
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

    public void addMatch(Match match)
    {
        listMatch.add(match);
    }

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public List<Match> getListMatch()
    {
        return listMatch;
    }

    /*------------------------------*\
    |*              Set             *|
    \*------------------------------*/

    public void setListMatch(List<Match> listMatch)
    {
        this.listMatch = listMatch;
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Private                        *|
    \*------------------------------------------------------------------*/

}