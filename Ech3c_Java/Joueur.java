/* This piece of code has been written by JMLMath */

public class Joueur
{
    private String name;

    /*----- CONSTRUCTORS -----*/

    public Joueur(String name)
    {
        this.name = new String(name);
    }

    public Joueur()
    {
        this.name = null;
    }

    /*------ GETTERS and SETTERS ---*/

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = new String(name);
    }
}