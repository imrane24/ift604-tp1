package ca.udes.ift604.tp1.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP
{

    /*------------------------------------------------------------------*\
    |*                          Constructeurs                           *|
    \*------------------------------------------------------------------*/

    public ServerTCP(int port) throws IOException
    {
        socket = new ServerSocket(port);
        for (int i = 0; i < 10; i++)
        {
            listBet = new ListBet[i];

        }
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Public                         *|
    \*------------------------------------------------------------------*/
    public void start()
    {
        Thread t = new Thread(new AcceptClient(socket));
        t.start();
        System.out.println("Les multi Thread sont pret !");

    }

    class AcceptClient implements Runnable
    {
        public AcceptClient(ServerSocket s)
        {
            socketserver = s;
        }

        public void run()
        {
            try
            {
                while (true)
                {
                    s1 = socketserver.accept(); // Un client se connecte on
                                                // l'accepte

                    ObjectInputStream serverInptStream = new ObjectInputStream(s1.getInputStream());
                    ObjectOutputStream serverOutputStream = new ObjectOutputStream(s1.getOutputStream());

                    System.out.println("Le client numéro " + nbrclient + " est connecté !");
                    nbrclient++;
                    try
                    {
                        // bet = new Bet(null, null, nbrclient, null);
                        bet = (Bet) serverInptStream.readObject();

                        validateBet();
                    } catch (ClassNotFoundException e)
                    {
                        e.printStackTrace();

                    }

                    serverInptStream.close();
                    serverOutputStream.close();

                }

            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }

        private void validateBet() throws IOException
        {

            if (bet.getMatch().getPeriod() < 2) // Pari effectué dans les 2
                                                // première mi-temps
            {
                String teamBet = bet.getTeamBet();

                if (teamBet == bet.getMatch().getTeam1())
                {
                    listBet[bet.getNumMatch()].SetBetTeam1(bet);
                } else
                {
                    listBet[bet.getNumMatch()].SetBetTeam2(bet);
                }

                // Envoie de confirmation au client
                printWriter = new PrintWriter(s1.getOutputStream());
                printWriter.println("M. " + bet.getUser().getLogin() + " vous avez misé : $" + bet.getBet() + " sur l'équipe : " + bet.getTeamBet());
                printWriter.flush();
                System.out.println("Pari sur l'équipe :" + bet.getTeamBet() + " Somme du pari : $" + bet.getBet());
                // essaivalidation();
            } else
            {
                // Envoie d'une erreur au client
                printWriter = new PrintWriter(s1.getOutputStream());
                printWriter.println("Pari impossible, limite de temps dépassé!");
                printWriter.flush();

            }

        }

        // private void essaivalidation()
        // {
        // System.out.println("nombre de pari: " + listBet.getSizeListTot());
        // System.out.println("Somme des paris: " + listBet.getSommeTotal());
        // System.out.println("Pari Team1 : " + listBet.getSizeList1());
        // System.out.println("Pari Team2 : " + listBet.getSizeList2());
        //
        // }

    }

    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/
    private ServerSocket socket;
    private ServerSocket socketserver;
    private Socket s1;
    private int nbrclient = 1;
    private Bet bet;
    private PrintWriter printWriter;
    private ListBet[] listBet;

}
