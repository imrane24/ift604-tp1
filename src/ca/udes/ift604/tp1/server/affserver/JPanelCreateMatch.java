package ca.udes.ift604.tp1.server.affserver;

import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelCreateMatch extends JPanel
{

    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private JTextField jTextFieldTeam1;
    private JTextField jTextFieldTeam2;
    private JTextField jTextFieldDate;
    private JTextField jTextFieldNameMatch;
    private JLabel jLabelTeam1;
    private JLabel jLabelTeam2;
    private JLabel jLabelNameMatch;
    private JLabel jLabelDate;

    private JButton jButtonValidate;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelCreateMatch()
    {
        geometry();
        control();
        appareance();
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public String getTeam1()
    {
        return jTextFieldTeam1.getText();
    }

    public String getTeam2()
    {
        return jTextFieldTeam2.getText();
    }

    public Date getDate()
    {
        try
        {
            SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd HH:mm");
            return formatter.parse(jTextFieldDate.getText());
        } catch (ParseException e)
        {
            System.err.println("Erreur format Date");
            e.printStackTrace();
        }
        return null;
    }

    public String getNameMatch()
    {
        return jTextFieldNameMatch.getText();
    }

    public JButton getjButtonValidate()
    {
        return jButtonValidate;
    }
    
    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    private void geometry()
    {

        jLabelTeam1 = new JLabel("Equipe 1 :", JLabel.CENTER);
        jLabelTeam2 = new JLabel("Equipe 2:", JLabel.CENTER);
        jLabelNameMatch = new JLabel("Nom du match :", JLabel.CENTER);
        jLabelDate = new JLabel("Date (yy-MM-dd HH:mm) :", JLabel.CENTER);

        jTextFieldTeam1 = new JTextField();
        jTextFieldTeam1.setColumns(10);
        jTextFieldTeam2 = new JTextField();
        jTextFieldTeam2.setColumns(10);

        jTextFieldNameMatch = new JTextField();
        jTextFieldNameMatch.setColumns(10);

        jTextFieldDate = new JTextField();
        jTextFieldDate.setColumns(10);

        jButtonValidate = new JButton("Valider");

        setLayout(new FlowLayout());
        add(jLabelTeam1);
        add(jTextFieldTeam1);
        add(jLabelTeam2);
        add(jTextFieldTeam2);

        add(jLabelNameMatch);
        add(jTextFieldNameMatch);
        add(jLabelDate);
        add(jTextFieldDate);

        add(jButtonValidate);
    }

    private void control()
    {
        // Rien
    }

    private void appareance()
    {
    }


}
