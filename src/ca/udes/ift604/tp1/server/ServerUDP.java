package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.match.Team;

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
            listMatch.add(new Match(new Date(), new Team("Bale"), new Team("Young Boys"), "match1"));
            listMatch.add(new Match(new Date(), new Team("Xamax"), new Team("Schaffouse"), "match2"));
            listMatch.add(new Match(new Date(), new Team("Sion"), new Team("Cpx"), "match3"));
            listMatch.add(new Match(new Date(), new Team("SRD"), new Team("Les Barbares"), "match4"));
            listMatch.add(new Match(new Date(), new Team("Kevin"), new Team("Musy"), "match5"));

            scenario(0);
            scenario(1);
            scenario(2);
            scenario(3);

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

    /*------------------------------------------------------------------*\
    |*                          Methodes Private                        *|
    \*------------------------------------------------------------------*/

    private void scenario(int i)
    {
        listMatch.get(i).start();
        for (int j = 0; j < i; j++)
        {
            listMatch.get(i).team1Goal();
            listMatch.get(i).team1Goal();

            listMatch.get(i).team2Penalty();

            listMatch.get(i).team2Goal();

            listMatch.get(i).team2EndPenalty();
            listMatch.get(i).team1Penalty();
        }
        listMatch.get(i).nextPeriod();
        listMatch.get(i).nextPeriod();
    }
}