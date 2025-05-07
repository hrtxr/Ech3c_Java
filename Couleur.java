/* This piece of code has been written by JMLMath */

public class Couleur extends Joueur 
{
    private String color;

    /*----- CONSTRUCTORS -----*/

    public Couleur(String color)
    {
        super();
        this.color = new String(color);
    }

    /*------ GETTERS and SETTERS ---*/

    public String getColor()
    {
        return this.color;
    }

    public void setColor(String color)
    {
        this.color = new String(color);
    }
}