package ca.udes.ift604.tp1.client.affmatch;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import ca.udes.ift604.tp1.match.Match;
import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelNorth extends Box
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private Match match;

    private JLabel jLabelName;
    private JLabel jLabelDate;
    private JLabel jLabelPeriod;
    private JLabel jLabelTime;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelNorth(Match match)
    {
        super(BoxLayout.X_AXIS);

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
        long millis = match.getChrono().getTimeLeft();
        int min = (int) (millis / 60000);
        millis -= (min * 60000);
        int sec = (int) ((millis / 1000) % 60);

        jLabelName = new JLabel(match.getName(), JLabel.CENTER);
        jLabelDate = new JLabel(match.getDate().toString(), JLabel.CENTER);
        jLabelPeriod = new JLabel(String.valueOf(match.getPeriod()), JLabel.CENTER);
        jLabelTime = new JLabel(String.format("%02d", min) + " : " + String.format("%02d", sec), JLabel.CENTER);

        add(Box.createHorizontalGlue());
        add(jLabelName);
        add(Box.createHorizontalGlue());
        add(jLabelDate);
        add(Box.createHorizontalGlue());
        add(jLabelPeriod);
        add(Box.createHorizontalGlue());
        add(jLabelTime);
        add(Box.createHorizontalGlue());
    }

    private void control()
    {

    }

    private void appareance()
    {
       jLabelDate.setForeground(ColorPalette.FOREGROUND_COLOR);
        jLabelName.setForeground(ColorPalette.FOREGROUND_COLOR);
        jLabelPeriod.setForeground(ColorPalette.FOREGROUND_COLOR);
        jLabelTime.setForeground(ColorPalette.FOREGROUND_COLOR);
        setBackground(ColorPalette.BACKGROUND_COLOR);
        setForeground(ColorPalette.FOREGROUND_COLOR);
    }

}
