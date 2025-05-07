/* This piece of code has been written by JMLMath */

public class Move extends Piece
{
    private int round_nb;   //the round number in which this move is played
    private int[] new_position = new int[2];
                            //pointers to precedent and next move in the chain
    private Move prev_move = null;
    private Move next_move = null;

    /*----- CONSTRUCTORS -----*/

    public Move(int round_nb, int[] new_position)
    {
        super();

        // just a little arguments checking
        if(new_position.length != 2)
        {
            throw new IllegalArgumentException("The new_position should contains only 2 args");
        }

        for(int i = 0; i < 2; i++)
        {
            this.new_position[i] = new_position[i];
        }
    }

    public Move(int round_nb, int[] new_position, Move prev_move)
    {
        super();
        this(round_nb, new_position);   // on réécrit pas ce qui est juste au dessus

        this.prev_move = prev_move;     // ici comme c'est une espèce de liste chainé on ne garde que le pointeur
                                        // pas de copie d'un nouvel objet ici, donc
    }

    /*------ GETTERS and SETTERS ---*/

    public int getRoundNb()
    {
        return this.round_nb;
    }

    public int[] getNewPosition()
    {
        return this.new_position;
    }

    public Move getPrevMove()
    {
        return this.prev_move;      // de même ici, on retourne les pointeurs, pas une copie de l'objet
    }

    public getNextMove()
    {
        return this.next_move;
    }

}