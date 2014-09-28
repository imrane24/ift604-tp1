package ca.udes.ift604.tp1.server.affserver.affevent;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelEventMatch extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JPanelEventNorth jPanelEventNorth;
    private JPanelEventCenter jPanelEventCenter;
    private List<Match> listMatch;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelEventMatch(List<Match> listMatch)
    {
        this.listMatch = listMatch;
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
        jPanelEventNorth = new JPanelEventNorth(listMatch);
        jPanelEventCenter = new JPanelEventCenter();
        setLayout(new BorderLayout());

        add(jPanelEventNorth, BorderLayout.NORTH);
        add(jPanelEventCenter, BorderLayout.CENTER);
    }

    private void control()
    {
        // Rien
    }

    private void appareance()
    {
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public JButton getjButtonStart()
    {
        return jPanelEventCenter.getjButtonStart();
    }

    public JButton getjButtonPause()
    {
        return jPanelEventCenter.getjButtonPause();
    }

    public JButton getjButtonGoal1()
    {
        return jPanelEventCenter.getjButtonGoal1();
    }

    public JButton getjButtonGoal2()
    {
        return jPanelEventCenter.getjButtonGoal2();
    }

    public JButton getjButtonPenalty1()
    {
        return jPanelEventCenter.getjButtonPenalty1();
    }

    public JButton getjButtonPenalty2()
    {
        return jPanelEventCenter.getjButtonPenalty2();
    }

    public JButton getjButtonEndPenalty1()
    {
        return jPanelEventCenter.getjButtonEndPenalty1();
    }

    public JButton getjButtonEndPenalty2()
    {
        return jPanelEventCenter.getjButtonEndPenalty2();
    }
    
    public JComboBox<String> getJcombobox()
    {
        return jPanelEventNorth.getJcombobox();
    }
    
    public int getIndexMatch()
    {
        return jPanelEventNorth.getIndexMatch();
    }
}
