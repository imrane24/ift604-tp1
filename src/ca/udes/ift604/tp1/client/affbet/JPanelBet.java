package ca.udes.ift604.tp1.client.affbet;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.match.User;
import ca.udes.ift604.tp1.server.Bet;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelBet extends JPanel
{

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelBet(Match match)
    {
        this.match = match;
        geometry();
        control();
        appareance();
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public JButton getjButtonValidate()
    {
        return jPanelCenter.getjButtonValidate();
    }

    public Bet getBet()
    {
        return new Bet(match, new User(jPanelCenter.getLoginBet()), jPanelCenter.getSommeBet(), jPanelCenter.getTeamBet());
    }

    public String getLoginBet()
    {
        return jPanelCenter.getLoginBet();
    }

    public int getSommeBet()
    {
        return jPanelCenter.getSommeBet();
    }

    public String getTeamBet()
    {
        return jPanelCenter.getTeamBet();
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    private void geometry()
    {
        // jLabel = new JLabel(bet.toString());
        jPanelNorth = new JPanelNorthBet(match);
        jPanelCenter = new JPanelCenterBet(match);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(jPanelNorth, BorderLayout.NORTH);
        add(jPanelCenter, BorderLayout.CENTER);

    }

    private void control()
    {

    }

    private void appareance()
    {
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }

    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JPanelNorthBet jPanelNorth;
    private JPanelCenterBet jPanelCenter;
    private JLabel jLabel;
    private Match match;

}
