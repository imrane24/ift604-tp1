package ca.udes.ift604.tp1.match;

import java.util.ArrayList;

public class ListeMatch
{

    private ArrayList<Match> liste;

    public ListeMatch()
    {
        liste = new ArrayList<Match>();
    }

    public ArrayList<Match> getListe()
    {
        return liste;
    }

    public void setListe(ArrayList<Match> liste)
    {
        this.liste = liste;
    }

}
