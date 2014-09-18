package ca.udes.ift604.tp1.match;

public class User
{

    private String name;
    private String firstName;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public User(String name, String firstName)
    {
        super();
        this.name = name;
        this.firstName = firstName;
    }

}
