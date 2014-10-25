package ca.udes.ift604.tp1.server;

import java.util.ArrayList;

import ca.udes.ift604.tp1.match.Bet;

public class ListBet
{
    /*------------------------------------------------------------------*\
    |*                          Constructeurs                           *|
    \*------------------------------------------------------------------*/
    public ListBet()
    {
        this.listBetTeam1 = new ArrayList<Bet>();
        this.listBetTeam2 = new ArrayList<Bet>();
    }

    /*------------------------------------------------------------------*\
    |*                          Methodes Public                         *|
    \*------------------------------------------------------------------*/
    /*------------------------------*\
    |*              Set             *|
    \*------------------------------*/
    public void SetBetTeam1(Bet bet)
    {
        listBetTeam1.add(bet);
        sommeTotal += bet.getBet();

    }

    public void SetBetTeam2(Bet bet)
    {
        listBetTeam2.add(bet);
        sommeTotal += bet.getBet();
    }

    /*------------------------------*\
    |*              Get             *|
    \*------------------------------*/
    public int getSommeTotal()
    {
        return sommeTotal;
    }

    public int getSizeList1()
    {
        return listBetTeam1.size();
    }

    public int getSizeList2()
    {
        return listBetTeam2.size();
    }

    public int getSizeListTot()
    {
        return listBetTeam1.size() + listBetTeam2.size();
    }

    /*------------------------------------------------------------------*\
    |*                          Attributs Private                       *|
    \*------------------------------------------------------------------*/

    private ArrayList<Bet> listBetTeam1;
    private ArrayList<Bet> listBetTeam2;
    private int sommeTotal;

}
