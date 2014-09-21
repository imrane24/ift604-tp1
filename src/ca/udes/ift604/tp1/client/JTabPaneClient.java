package ca.udes.ift604.tp1.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JTabbedPane;

import ca.udes.ift604.tp1.client.affmatch.JPanelMatch;
import ca.udes.ift604.tp1.match.Bet;
import ca.udes.ift604.tp1.match.User;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JTabPaneClient extends JTabbedPane
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JPanelListMatch jPanelListMatch;
    private JPanelMatch jPanelMatch;
    private JPanelBet jPanelBet;
    private ClientUDP client;
    private int portServer;
    private InetAddress ip;
    private String nameMatch;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JTabPaneClient(int portServer, String ipServer) throws IOException
    {
        this.portServer = portServer;
        ip = InetAddress.getByName(ipServer);
        client = new ClientUDP(ip, portServer);

        client.start("update");

        nameMatch = client.getListMatch().get(0).getName();
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

    private void geometry()
    {
        jPanelListMatch = new JPanelListMatch(client.getListMatch());
        jPanelMatch = new JPanelMatch(client.getMatch(nameMatch));
        jPanelBet = new JPanelBet(new Bet(client.getMatch(nameMatch), new User("pa", "Kev"), 100));

        removeAll();
        add("Match", jPanelMatch);
        add("Liste Des Matchs", jPanelListMatch);
        add("Paris", jPanelBet);
    }

    private void control()
    {
        jPanelMatch.getjButtonUpdate().addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    int i = getSelectedIndex();
                    client = new ClientUDP(ip, portServer);
                    client.start("update");

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
        });

        jPanelListMatch.getjButtonUpdate().addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent event)
            {
                try
                {
                    int i = getSelectedIndex();
                    client = new ClientUDP(ip, portServer);
                    client.start("update");

                    nameMatch = jPanelListMatch.getNameMatch();
                    geometry();
                    control();
                    appareance();
                    setSelectedIndex(i);

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
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
}
