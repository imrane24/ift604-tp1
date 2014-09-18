package ca.udes.ift604.tp1.match;

public class Penalty
{

    private Match match;
    private Team team;

    public Match getMatch()
    {
        return match;
    }

    public void setMatch(Match match)
    {
        this.match = match;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public Penalty(Match match, Team team)
    {
        super();
        this.match = match;
        this.team = team;
    }

}
