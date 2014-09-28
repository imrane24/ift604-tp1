package ca.udes.ift604.tp1.server.affserver.affevent;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelEventCenter extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JButton jButtonStart;
    private JButton jButtonPause;
    private JButton jButtonGoal1;
    private JButton jButtonGoal2;
    private JButton jButtonPenalty1;
    private JButton jButtonPenalty2;
    private JButton jButtonEndPenalty1;
    private JButton jButtonEndPenalty2;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelEventCenter()
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

    private void geometry()
    {
        jButtonGoal1 = new JButton("But Equipe 1");
        jButtonGoal2 = new JButton("But Equipe 2");
        jButtonPenalty1 = new JButton("Penalitée 1");
        jButtonPenalty2 = new JButton("Penalitée 2");
        jButtonEndPenalty1 = new JButton("Fin Penalitée 1");
        jButtonEndPenalty2 = new JButton("Fin Penalitée 2");
        jButtonStart = new JButton("Start");
        jButtonPause = new JButton("Pause");

        setLayout(new GridLayout(4, 2, 10, 10));

        add(jButtonStart);
        add(jButtonPause);
        add(jButtonGoal1);
        add(jButtonGoal2);
        add(jButtonPenalty1);
        add(jButtonPenalty2);
        add(jButtonEndPenalty1);
        add(jButtonEndPenalty2);
    }

    private void control()
    {

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
        return jButtonStart;
    }

    public JButton getjButtonPause()
    {
        return jButtonPause;
    }

    public JButton getjButtonGoal1()
    {
        return jButtonGoal1;
    }

    public JButton getjButtonGoal2()
    {
        return jButtonGoal2;
    }

    public JButton getjButtonPenalty1()
    {
        return jButtonPenalty1;
    }

    public JButton getjButtonPenalty2()
    {
        return jButtonPenalty2;
    }

    public JButton getjButtonEndPenalty1()
    {
        return jButtonEndPenalty1;
    }

    public JButton getjButtonEndPenalty2()
    {
        return jButtonEndPenalty2;
    }
}
