package ca.udes.ift604.tp1.client;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class JFrameClient extends JFrame
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private int portServerUDP;
    private int portServerTCP;
    private String ipServer;
    private JTabPaneClient jTabPaneClient;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JFrameClient(int portServerUDP, int portServerTCP, String ipServer) throws IOException
    {
        this.portServerUDP = portServerUDP;
        this.portServerTCP = portServerTCP;
        this.ipServer = ipServer;

        geometry();
        control();
        appareance();
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    private void geometry() throws IOException
    {
        jTabPaneClient = new JTabPaneClient(portServerUDP, portServerTCP, ipServer);
        setLayout(new BorderLayout());
        add(jTabPaneClient);
    }

    private void control()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void appareance()
    {
        setTitle("HockeyLive : La soirée du hockey");
        setLocation(900, 200);
        setSize(600, 480);
        setResizable(true);
        setVisible(true);
    }
}
