/* This piece of code has been written by JMLMath */

public class Move
{
    private int round_nb;   //the round number in which this move is played
    private int[] new_position = new int[2];
    private String piece_letter;

    /*----- CONSTRUCTORS -----*/

    public Move(int round_nb, int[] new_position)
    {
        // just a little arguments checking
        if(new_position.length != 2)
        {
            throw new IllegalArgumentException("The new_position should contains only 2 args");
        }

        for(int i = 0; i < 2; i++)
        {
            this.new_position[i] = new_position[i];
        }

        this.round_nb = round_nb;
        this.piece_letter = null;
    }

    public Move(int round_nb, int[] new_position, Piece movedPiece)
    {
        this(round_nb, new_position);   // on réécrit pas ce qui est juste au dessus
        this.piece_letter = movedPiece.getLetter();
    }

    public Move(Move m)
    {
        this.round_nb = m.getRoundNb();
        this.new_position = m.getNewPosition();
        this.piece_letter = m.getPieceLetter();
    }

    /*------ GETTERS and SETTERS ---*/

    public int getRoundNb()
    {
        return this.round_nb;
    }

    public int[] getNewPosition()
    {
        int[] returned = new int[2];
        for(int i = 0; i < 2; i++)
        {
            returned[i] = this.new_position[i];
        }
        return new_position;
    }

    public int getNewPositionX()
    {
        return this.new_position[0];
    }

    public int getNewPositionY()
    {
        return this.new_position[1];
    }

    public String getPieceLetter()
    {
        return new String(this.piece_letter);
    }

    /*---------- Other Methods -----*/

    public String toString()
    {
        String move_str = "Move " + this.round_nb + " : " + piece_letter + " to " + Echiquier.coord_int_to_str(this.getNewPosition());
        return move_str;
    }

}