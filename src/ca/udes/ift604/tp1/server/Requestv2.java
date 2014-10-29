package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.List;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.tools.Tools;

public class Requestv2 implements Runnable
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private final DatagramPacket receivePacket;
    private final DatagramSocket serverSocket;
    private String request;

    private static final int size = 1024;
    static byte sendBuffer[] = new byte[size];

    private List<Match> listMatch;

    /*------------------------------------------------------------------*\
    |*                          Constructeurs                           *|
    \*------------------------------------------------------------------*/

    public Requestv2(DatagramSocket serverSocket, DatagramPacket receivePacket, List<Match> listMatch) throws SocketException
    {
        this.receivePacket = receivePacket;
        this.serverSocket = serverSocket;
        this.listMatch = listMatch;

        // Reception de la requete du client
        request = new String(receivePacket.getData());
        System.out.println("Nouvelle requette : " + request);
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Public                         *|
    \*------------------------------------------------------------------*/

    @Override
    public void run()
    {
        try
        {
            // Requette du client
            if (request.contains("update"))
            {
                // On envoi en premier la taille de la liste
                sendBuffer = Tools.serealizer(new Integer(listMatch.size()));

                DatagramPacket sizeListPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(sizeListPacket);

            } else if (request.contains("ok"))
            {
                int index = request.indexOf("ok") + 2;
                int num = Character.getNumericValue(request.charAt(index));
                
                //num++;
                if (num < listMatch.size())
                {
                    System.out.println("Envoi match" + num);

                    // On envoi la liste complete
                    sendBuffer = Tools.serealizer(listMatch.get(num));

                    DatagramPacket replyPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
                    serverSocket.send(replyPacket);
                }
            }

        } catch (IOException e)
        {
            System.err.println("Error Request\n");
            e.printStackTrace();
        }
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Private                        *|
    \*------------------------------------------------------------------*/
}
