package ca.udes.ift604.tp1.match;

public class Bet
{

    private Match match;
    private User user;
    private int bet;

    public Match getMatch()
    {
        return match;
    }

    public void setMatch(Match match)
    {
        this.match = match;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public int getBet()
    {
        return bet;
    }

    public void setBet(int bet)
    {
        this.bet = bet;
    }

    public Bet(Match match, User user, int bet)
    {
        super();
        this.match = match;
        this.user = user;
        this.bet = bet;
    }

}
