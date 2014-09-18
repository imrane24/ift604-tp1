package ca.udes.ift604.tp1.match;

public class Chrono
{

    /*------------------------------------------------------------------*\
    |*							Constructeurs							*|
    \*------------------------------------------------------------------*/

    public Chrono(long timeTotal)
    {
        isRunning = false;
        timeStart = -1;
        timeRunnig = 0;
        this.timeTotal = timeTotal;
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Public							*|
    \*------------------------------------------------------------------*/

    public void start()
    {
        isRunning = true;
        timeStart = System.currentTimeMillis();
    }

    public void pause()
    {
        isRunning = false;
        timeRunnig += System.currentTimeMillis() - timeStart;
    }

    public void reset()
    {
        isRunning = false;
        timeStart = -1;
        timeTotal = -1;
        timeRunnig = 0;
    }

    public boolean isFinish()
    {
        if (getTimeRunning() >= timeTotal)
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

    public long getTimeRunning()
    {
        if (isRunning == true)
        {
            return System.currentTimeMillis() - timeStart;
        } else
        {
            return timeRunnig;
        }
    }

    public boolean isRunning()
    {
        return isRunning;
    }

    /*------------------------------------------------------------------*\
    |*							Methodes Private						*|
    \*------------------------------------------------------------------*/

    /*------------------------------------------------------------------*\
    |*							Attributs Private						*|
    \*------------------------------------------------------------------*/

    // Tools
    private long timeStart;
    private long timeRunnig;
    private long timeTotal;
    private boolean isRunning;
}
