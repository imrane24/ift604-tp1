package ca.udes.ift604.tp1.match;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Team implements Serializable
{

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Team(String name)
    {
        this.name = name;
    }
}
