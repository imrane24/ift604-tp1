package ca.udes.ift604.tp1.client;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Bet;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelBet extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JLabel jLabel;
    private Bet bet;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelBet(Bet bet)
    {
        this.bet = bet;
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
        jLabel = new JLabel(bet.toString());
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(jLabel);
    }

    private void control()
    {

    }

    private void appareance()
    {
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }

}
