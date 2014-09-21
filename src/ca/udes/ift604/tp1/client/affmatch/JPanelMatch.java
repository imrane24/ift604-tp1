package ca.udes.ift604.tp1.client.affmatch;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelMatch extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JPanelNorth jPanelNorth;
    private JPanelCenter jPanelCenter;
    private JButton jButtonUpdate;
    private Match match;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelMatch(Match match)
    {
        this.match = match;
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
        jPanelNorth = new JPanelNorth(match);
        jPanelCenter = new JPanelCenter(match);
        jButtonUpdate = new JButton("Actualiser");
        setLayout(new BorderLayout());

        add(jPanelNorth, BorderLayout.NORTH);
        add(jPanelCenter, BorderLayout.CENTER);
        add(jButtonUpdate, BorderLayout.SOUTH);
    }

    private void control()
    {
       // Rien
    }

    private void appareance()
    {
        jButtonUpdate.setBackground(ColorPalette.BUTTON_BACKGROUND_COLOR);
        jButtonUpdate.setForeground(ColorPalette.BUTTON_FOREGROUND_COLOR);
        
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }
    
    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public JButton getjButtonUpdate()
    {
        return this.jButtonUpdate;
    }

}
