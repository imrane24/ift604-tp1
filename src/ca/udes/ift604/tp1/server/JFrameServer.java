package ca.udes.ift604.tp1.server;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class JFrameServer extends JFrame
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private int portServer;
    private JPanelServer jPanelServer;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JFrameServer(int portServer) throws IOException
    {
        this.portServer = portServer;

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
        jPanelServer = new JPanelServer(portServer);
        setLayout(new BorderLayout());
        add(jPanelServer);
    }

    private void control()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void appareance()
    {
        setTitle("HockeyLive : La soir�e du hockey");
        setLocation(600, 200);
        setSize(600, 480);
        setResizable(true);
        setVisible(true);
    }
}