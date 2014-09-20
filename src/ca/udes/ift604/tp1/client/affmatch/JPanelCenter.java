package ca.udes.ift604.tp1.client.affmatch;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ca.udes.ift604.tp1.match.Match;

public class JPanelCenter extends JPanel
{
    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private Match match;

    private JButton jButtonUpdate;

    private JLabel jLabelEquipe;
    private JLabel jLabelGoal;
    private JLabel jLabelPenalty;
    private JLabel jLabelTeam1;
    private JLabel jLabelTeam2;
    private JLabel jLabelGoal1;
    private JLabel jLabelGoal2;
    private JLabel jLabelPenalty1;
    private JLabel jLabelPenalty2;

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public JPanelCenter(Match match)
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
        jLabelEquipe = new JLabel("Equipe :", JLabel.CENTER);
        jLabelGoal = new JLabel(match.getTeam1().getName(), JLabel.CENTER);
        jLabelPenalty = new JLabel(match.getTeam2().getName(), JLabel.CENTER);
        jLabelTeam1 = new JLabel("Goal :", JLabel.CENTER);
        jLabelTeam2 = new JLabel(String.valueOf(match.getGoalTeam1()), JLabel.CENTER);
        jLabelGoal1 = new JLabel(String.valueOf(match.getGoalTeam2()), JLabel.CENTER);
        jLabelGoal2 = new JLabel("Pénalités en Cours", JLabel.CENTER);
        jLabelPenalty1 = new JLabel(String.valueOf(match.getPenaltyTeam1()), JLabel.CENTER);
        jLabelPenalty2 = new JLabel(String.valueOf(match.getPenaltyTeam2()), JLabel.CENTER);

        setLayout(new GridLayout(3, 3));
        add(jLabelEquipe);
        add(jLabelGoal);
        add(jLabelPenalty);
        add(jLabelTeam1);
        add(jLabelTeam2);
        add(jLabelGoal1);
        add(jLabelGoal2);
        add(jLabelPenalty1);
        add(jLabelPenalty2);
    }

    private void control()
    {

    }

    private void appareance()
    {
        // RIEN
    }

}
