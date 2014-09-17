package Classe;

public class Chrono
{

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public Chrono(long tempsTotal)
    {
        enFonctionnement = false;
        tempsDebut = -1;
        tempsEcoule = 0;
        this.tempsTotal = tempsTotal;
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    public void start()
    {
        enFonctionnement = true;
        tempsDebut = System.currentTimeMillis();
    }

    public void pause()
    {
        enFonctionnement = false;
        tempsEcoule += System.currentTimeMillis() - tempsDebut;
    }

    public void reset()
    {
        enFonctionnement = false;
        tempsDebut = -1;
        tempsTotal = -1;
        tempsEcoule = 0;
    }

    public boolean isEcoule()
    {
        if (getTempsEcoule() >= tempsTotal)
        {
            return true;
        } else
        {
            return false;
        }
    }

    /*------------------------------*\
    |*				Set				*|
    \*------------------------------*/

    /*------------------------------*\
    |*				Get				*|
    \*------------------------------*/

    public long getTempsEcoule()
    {
        if (enFonctionnement == true)
        {
            return System.currentTimeMillis() - tempsDebut;
        } else
        {
            return tempsEcoule;
        }
    }

    public boolean isEnFonctionnement()
    {
        return enFonctionnement;
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Attributs Private						*|
    \*------------------------------------------------------------------*/

    // Tools
    private long tempsDebut;
    private long tempsEcoule;
    private long tempsTotal;
    private boolean enFonctionnement;
}
