package ca.udes.ift604.tp1.match;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Match implements Serializable
{

    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private Date date;
    private Team team1;
    private Team team2;
    private int goalTeam1;
    private int goalTeam2;
    private int penaltyTeam1; // nombre de joueur penalise en temps reel
    private int penaltyTeam2;
    private int period; // seulement 1, 2 ou 3
    private StateMatch state;
    private Chrono chrono;
    private String name;

    public enum StateMatch
    {
        JEU, SUSPENDU, FINI
    }

    /*------------------------------------------------------------------*\
    |*                          Constructeurs                           *|
    \*------------------------------------------------------------------*/

    public Match(Date date, Team team1, Team team2, String name)
    {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.name = name;
        goalTeam1 = 0;
        goalTeam2 = 0;
        penaltyTeam1 = 0;
        penaltyTeam2 = 0;
        period = 1;
        chrono = new Chrono(1200000); // 20 minutes par p�riodes
        state = StateMatch.SUSPENDU;
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Public                         *|
    \*------------------------------------------------------------------*/

    public void team1Goal()
    {
        goalTeam1++;
    }

    public void team2Goal()
    {
        goalTeam2++;
    }

    public void team1Penalty()
    {
        penaltyTeam1++;
    }

    public void team2Penalty()
    {
        penaltyTeam2++;
    }

    public void team1EndPenalty()
    {
        if (penaltyTeam1 > 0)
        {
            penaltyTeam1--;
        }
    }

    public void team2EndPenalty()
    {
        if (penaltyTeam2 > 0)
        {
            penaltyTeam2--;
        }
    }

    public void nextPeriod()
    {
        if (period <= 3)
        {
            period++;
        } else
        {
            System.out.println("Fin du match");
            this.state = StateMatch.FINI;
        }
    }

    public void pause()
    {
        chrono.pause();
        this.state = StateMatch.SUSPENDU;
    }

    public void start()
    {
        chrono.start();
        this.state = StateMatch.JEU;
    }

    public boolean endPeriod()
    {
        return (chrono.isFinish());
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Match :\nEquipes : ");
        builder.append(team1.getName());
        builder.append(" - ");
        builder.append(team2.getName());

        builder.append("\nMatch du ");
        builder.append(date.toString());

        builder.append("\nPeriod : ");
        builder.append(period);

        builder.append("\nScore : ");
        builder.append(goalTeam1);
        builder.append(" - ");
        builder.append(goalTeam2);

        builder.append("\nPenalit�s : ");
        builder.append(penaltyTeam1);
        builder.append(" - ");
        builder.append(penaltyTeam2);
        builder.append("\n");
        return builder.toString();
    }

    /*------------------------------*\
    |*              Set             *|
    \*------------------------------*/

    /*
     * public void setButEquipe1(int butEquipe1) { this.butEquipe1 = butEquipe1;
     * }
     * 
     * public void setButEquipe2(int butEquipe2) { this.butEquipe2 = butEquipe2;
     * }
     * 
     * public void setPenaliteEquipe1(int penaliteEquipe1) {
     * this.penaliteEquipe1 = penaliteEquipe1; }
     * 
     * public void setPenaliteEquipe2(int penaliteEquipe2) {
     * this.penaliteEquipe2 = penaliteEquipe2; }
     * 
     * public void setEquipe1(Equipe equipe1) { this.equipe1 = equipe1; }
     * 
     * public void setEquipe2(Equipe equipe2) { this.equipe2 = equipe2; }
     * 
     * public void setTiersTemps(int tiersTemps) { this.tiersTemps = tiersTemps;
     * }
     */

    public void setDate(Date date)
    {
        this.date = date;
    }

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/

    public int getGoalTeam1()
    {
        return goalTeam1;
    }

    public int getGoalTeam2()
    {
        return goalTeam2;
    }

    public int getPenaltyTeam1()
    {
        return penaltyTeam1;
    }

    public int getPenaltyTeam2()
    {
        return penaltyTeam2;
    }

    public int getPeriod()
    {
        return period;
    }

    public Team getTeam1()
    {
        return team1;
    }

    public Team getTeam2()
    {
        return team2;
    }

    public Date getDate()
    {
        return date;
    }

    public Chrono getChrono()
    {
        return chrono;
    }
 
    public String getName()
    {
        return name;
    }
    
    public StateMatch getStateMatch()
    {
        return state;
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Private                        *|
    \*------------------------------------------------------------------*/
}
