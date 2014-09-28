package ca.udes.ift604.tp1.server.affserver.affevent;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Match;

public class JPanelEventNorth extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JComboBox<String> jCombobox;
    private JLabel jLabel;

    /*------------------------------------------------------------------*\
    |*                          Constructeurs                           *|
    \*------------------------------------------------------------------*/

    public JPanelEventNorth(List<Match> listMatch)
    {
        jCombobox = new JComboBox<String>();
        for (Match element : listMatch)
        {
            jCombobox.addItem(element.getName());
        }

        geometry();
        control();
        appareance();
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Public                         *|
    \*------------------------------------------------------------------*/

    public JComboBox<String> getJcombobox()
    {
        return jCombobox;
    }

    public void setJcombobox(JComboBox<String> jcombobox)
    {
        this.jCombobox = jcombobox;
    }

    public int getIndexMatch()
    {
        return jCombobox.getSelectedIndex();
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Private                        *|
    \*------------------------------------------------------------------*/

    private void geometry()
    {

        jLabel = new JLabel("Choix du match", JLabel.CENTER);

        setLayout(new FlowLayout());
        add(jLabel);
        add(jCombobox);
    }

    private void control()
    {
        // Rien
    }

    private void appareance()
    {
    }

}
