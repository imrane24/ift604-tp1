package ca.udes.ift604.tp1.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import ca.udes.ift604.tp1.client.affbet.JPanelBet;
import ca.udes.ift604.tp1.client.affmatch.JPanelMatch;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JTabPaneClient extends JTabbedPane
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JPanelListMatch jPanelListMatch;
    private JPanelMatch jPanelMatch;
    private JPanelBet jPanelBet;

    private int portServerUDP;
    private int portServerTCP;
    private InetAddress ip;

    private ClientUDP clientUDP;
    private ClientTCP clientTCP;

    private String nameMatch;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JTabPaneClient(int portServerUDP, int portServerTCP, String ipServer) throws IOException
    {
        this.portServerUDP = portServerUDP;
        this.portServerTCP = portServerTCP;
        ip = InetAddress.getByName(ipServer);
        clientUDP = new ClientUDP(ip, portServerUDP);
        clientUDP.start("update");

        // TODO Gerer le client TCP pour les paris ici
        // clientTCP = new ClientTCP(ip, portServerTCP, new Bet);

        nameMatch = clientUDP.getListMatch().get(0).getName();
        geometry();
        control();
        appareance();
        runThreadUpdate();
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    private void geometry()
    {
        jPanelListMatch = new JPanelListMatch(clientUDP.getListMatch());
        jPanelMatch = new JPanelMatch(clientUDP.getMatch(nameMatch));
        jPanelBet = new JPanelBet(clientUDP.getMatch(nameMatch));

        removeAll();
        add("Match", jPanelMatch);
        add("Liste Des Matchs", jPanelListMatch);
        add("Paris", jPanelBet);
    }

    private void control()
    {
        // Mise � jour par le bouton Actualiser dans Match
        jPanelMatch.getjButtonUpdate().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                updateListMatch();
            }
        });

        // Mise � jour par le bouton Actualiser dans ListMatch
        jPanelListMatch.getjButtonUpdate().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                updateListMatch();
            }
        });
    }

    private void appareance()
    {
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }

    public JButton getjButtonUpdate()
    {
        return jPanelMatch.getjButtonUpdate();
    }

    public void setNameMatch(String nameMatch)
    {
        this.nameMatch = nameMatch;
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Private                        *|
    \*------------------------------------------------------------------*/

    private void updateListMatch()
    {
        try
        {
            int i = getSelectedIndex();
            clientUDP = new ClientUDP(ip, portServerUDP);
            clientUDP.start("update");

            if (jPanelListMatch.isSelectMatch())
            {
                nameMatch = jPanelListMatch.getNameMatch();
                jPanelListMatch.setSelectMatch(false);
            }
            geometry();
            control();
            appareance();
            setSelectedIndex(i);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void runThreadUpdate()
    {
        // Mise � jour toutes les 2 minutes
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    try
                    {
                        Thread.sleep(120000);
                        updateListMatch();
                    } catch (InterruptedException e)
                    {
                        // Arret du thread
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }).start();
    }
}
