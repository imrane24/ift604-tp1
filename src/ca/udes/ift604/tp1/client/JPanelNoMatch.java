package ca.udes.ift604.tp1.client;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.tools.ColorPalette;

public class JPanelNoMatch extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JButton jButtonUpdate;
    private JLabel jLabelError;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelNoMatch()
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
        jButtonUpdate = new JButton("Actualiser");
        jLabelError = new JLabel("Erreur, Pas de match disponible\n Cliquer sur Actualiser pour réessayer");
        setLayout(new BorderLayout());

        add(jLabelError, BorderLayout.CENTER);
        add(jButtonUpdate, BorderLayout.SOUTH);
    }

    private void control()
    {

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
