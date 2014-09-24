package ca.udes.ift604.tp1.client.affbet;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import ca.udes.ift604.tp1.match.Match;

public class JPanelCenterBet extends JPanel
{

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelCenterBet(Match match)
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

        jLabelLogin = new JLabel("Login :", JLabel.CENTER);
        jTextFieldLogin = new JTextField();
        jTextFieldLogin.setColumns(10);
        jTextFieldSomme = new JTextField();
        jTextFieldSomme.setColumns(10);
        jLabelSomme = new JLabel("Somme :", JLabel.CENTER);
        jLabelTeam = new JLabel("Equipe :", JLabel.CENTER);
        jSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 1));

        jSpinner.setSize(100, 100);
        jButtonValidate = new JButton("Valider Pari");
        jcombobox = new JComboBox<String>();
        jcombobox.addItem(match.getTeam1());
        jcombobox.addItem(match.getTeam2());

        setLayout(new FlowLayout());
        add(jLabelLogin);
        add(jTextFieldLogin);
        add(jLabelSomme);
        add(jSpinner);
        add(jLabelTeam);
        add(jcombobox);
        add(jButtonValidate);

    }

    private void control()
    {
        // Rien
    }

    private void appareance()
    {
    }

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public JButton getjButtonValidate()
    {
        return this.jButtonValidate;
    }

    public String getLoginBet()
    {
        return jTextFieldLogin.getText();
    }

    public int getSommeBet()
    {
        return (Integer) jSpinner.getValue();
    }

    public String getTeamBet()
    {
        return (String) jcombobox.getSelectedItem();
    }

    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private Match match;
    private JTextField jTextFieldLogin;
    private JTextField jTextFieldSomme;
    private JLabel jLabelLogin;
    private JLabel jLabelSomme;
    private JLabel jLabelTeam;
    private JSpinner jSpinner;
    private JButton jButtonValidate;
    private JComboBox<String> jcombobox;

}
