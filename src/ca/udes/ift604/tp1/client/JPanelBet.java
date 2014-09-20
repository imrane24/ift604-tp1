package ca.udes.ift604.tp1.client;

import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Bet;

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
        this.addComponentListener(new ComponentAdapter()
        {

            @Override
            public void componentResized(ComponentEvent event)
            {

            }
        });
    }

    private void appareance()
    {
        // RIEN
    }

}
