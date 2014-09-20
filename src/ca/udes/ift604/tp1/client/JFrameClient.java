package ca.udes.ift604.tp1.client;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;

public class JFrameClient extends JFrame
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JTabPaneClient jTabPaneClient;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JFrameClient() throws IOException
    {
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
        jTabPaneClient = new JTabPaneClient();
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
        setLocation(600, 200);
        setSize(600, 480);
        setResizable(true);
        setVisible(true);
    }
}
