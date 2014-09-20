package ca.udes.ift604.tp1.client;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Match;

public class JPanelListMatch extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private List<Match> listMatch;
    private JButton jButtonUpdate;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelListMatch(List<Match> listMatch)
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
        jButtonUpdate = new JButton("Actualiser");

        Box boxV = Box.createVerticalBox();

        boxV.add(Box.createVerticalGlue());
        for (Match element : listMatch)
        {
            JButton jButton = new JButton(element.getName());
            boxV.add(jButton);
            boxV.add(Box.createVerticalGlue());
        }
        Box boxH = Box.createHorizontalBox();
        boxH.add(Box.createHorizontalGlue());
        boxH.add(boxV);
        boxH.add(Box.createHorizontalGlue());
        setLayout(new BorderLayout());

        add(boxH, BorderLayout.CENTER);
        add(jButtonUpdate, BorderLayout.SOUTH);

    }

    private void control()
    {

    }

    private void appareance()
    {
        // RIEN
    }

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public JButton getjButtonUpdate()
    {
        return this.jButtonUpdate;
    }

}
