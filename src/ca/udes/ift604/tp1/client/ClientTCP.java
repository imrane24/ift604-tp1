package ca.udes.ift604.tp1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import ca.udes.ift604.tp1.match.Bet;

public class ClientTCP
{

    /*------------------------------------------------------------------*\
    |*                          Constructeurs                           *|
    \*------------------------------------------------------------------*/

    public ClientTCP(InetAddress address, int port, Bet bet) throws UnknownHostException, IOException
    {
        this.port = port;
        this.address = address;
        this.bet = bet;
        socket = new Socket(address, port);
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Public                         *|
    \*------------------------------------------------------------------*/
    public void start()
    {
        try
        {
            // bet = new Bet(new Match(new Date(), new Team("Sherbrooke"), new
            // Team("Montreal")), new User("Tata"), 100, new Team("Montreal"));

            ObjectOutputStream clientOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream clientInputStream = new ObjectInputStream(socket.getInputStream());

            clientOutputStream.writeObject(bet);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message_distant = in.readLine();
            System.out.println(message_distant);

            clientOutputStream.close();
            clientInputStream.close();

        } catch (IOException e)
        {

            e.printStackTrace();
        }

    }

    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private Bet bet;
    private int port;
    private InetAddress address;
    private Socket socket;
    private BufferedReader in;
}
