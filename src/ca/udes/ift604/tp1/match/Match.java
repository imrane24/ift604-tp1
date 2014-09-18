package ca.udes.ift604.tp1.match;

import java.util.Date;

public class Match
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

    public enum StateMatch
    {
        JEU, SUSPENDU, FINI
    }

    /*------------------------------------------------------------------*\
    |*                          Constructeurs                           *|
    \*------------------------------------------------------------------*/

    public Match(Date date, Team team1, Team team2)
    {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        goalTeam1 = 0;
        goalTeam2 = 0;
        penaltyTeam1 = 0;
        penaltyTeam2 = 0;
        period = 1;
        state = StateMatch.SUSPENDU;
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Public                         *|
    \*------------------------------------------------------------------*/

    public void team1Goal()
    {
        goalTeam1 = goalTeam1++;
    }

    public void team2Goal()
    {
        goalTeam2 = goalTeam2++;
    }

    public void team1Penalty()
    {
        penaltyTeam1 = penaltyTeam1++;
    }

    public void team2Penalty()
    {
        penaltyTeam2 = penaltyTeam2++;
    }

    public void team1EndPenalty()
    {
        penaltyTeam1 = penaltyTeam1--;
    }

    public void team2EndPenalty()
    {
        penaltyTeam2 = penaltyTeam2--;
    }

    public void nextPeriod()
    {
        if (period <= 3)
        {
            period = period++;
        } else
        {
            System.out.println("Fin du match");
            this.state = StateMatch.FINI;
        }
    }

    public void pause()
    {
        this.state = StateMatch.SUSPENDU;
    }

    public void restart()
    {
        this.state = StateMatch.JEU;
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

    public StateMatch getStateMatch()
    {
        return state;
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Private                        *|
    \*------------------------------------------------------------------*/
}
