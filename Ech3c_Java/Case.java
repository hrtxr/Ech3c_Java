/* This piece of code has been written by JMLMath */

public class Case
{
    private String case_color;
    private Piece piece_on_it = null;

    /*----- CONSTRUCTORS -----*/

    public Case()
    {
        this.case_color = "White";
    }

    public Case(String case_color)
    {
        this.case_color = new String(case_color);
    }

    public Case(String case_color, Piece piece_on_it)
    {
        this(case_color);
        this.piece_on_it = piece_on_it; // cannot create a new instance of an abstract object
    }

    public Case(Piece piece_on_it)
    {
        this.piece_on_it = piece_on_it; // cannot create a new instance of an abstract object
    }

    /*------ GETTERS and SETTERS ---*/

    public String getCaseColor()
    {
        return new String(this.case_color);
    }

    public Piece getPieceOnIt()
    {
        return piece_on_it; // attention ne retourne pas une nouvelle instance !
    }

    public void setPieceOnIt(Piece piece_on_it)
    {
        this.piece_on_it = piece_on_it; // cannot create a new instance of an abstract object
    }

    // No setCaseColor() here. 
    // Normally, we cannot change any case color during a game.
    // En principe, on ne peut pas modifier la couleur d'une case pendant une partie. 
}