package ca.udes.ift604.tp1.server.affserver;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class JFrameServer extends JFrame
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private int portServerUDP;
    private int portServerTCP;
    private JTabPaneServer jTabPaneServer;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JFrameServer(int portServerUDP, int portServerTCP) throws IOException
    {
        this.portServerUDP = portServerUDP;
        this.portServerTCP = portServerTCP;

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
        jTabPaneServer = new JTabPaneServer(portServerUDP, portServerTCP);
        setLayout(new BorderLayout());
        add(jTabPaneServer);
    }

    private void control()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void appareance()
    {
        setTitle("HockeyLive : La soirée du hockey");
        setLocation(300, 200);
        setSize(600, 480);
        setResizable(true);
        setVisible(true);
    }
}
