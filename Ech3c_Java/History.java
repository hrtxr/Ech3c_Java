/* This piece of code has been written by JMLMath */

import java.util.ArrayList;

public class History
{
    private ArrayList<Move> PosList;
    private int current_round;

    /*----- CONSTRUCTORS -----*/

    public History()
    {
        this.PosList = new ArrayList<Move>(40); // instanciate by default to 40 because
                                                // average number of move during a chess game is 40
        this.current_round = 0;
    }

    /*------ GETTERS and SETTERS ---*/

    public Move[] getLast()
    {
        int history_size = this.PosList.size();
        int nb_latest_moves = 5;                    // by default, returns only 5 latest moves
        Move[] latest_moves;

        if(this.current_round < 5)
        {
            nb_latest_moves = history_size;         // if the history contains less that 5 elements
        }

        latest_moves = new Move[nb_latest_moves];

        for(int i = history_size - 1; i > history_size - nb_latest_moves; i--)
        {
            latest_moves[i] = new Move(PosList.get(i));
        }
        
        return latest_moves;
    }

    public Move[] getLast(int n)
    {
        int history_size = this.PosList.size();
        int nb_latest_moves = n;                    // by default, returns only 5 latest moves
        Move[] latest_moves;

        if(this.current_round < n)
        {
            nb_latest_moves = history_size;         // if the history contains less that 5 elements
        }

        latest_moves = new Move[nb_latest_moves];

        for(int i = history_size - 1; i > history_size - nb_latest_moves; i--)
        {
            latest_moves[i] = new Move(PosList.get(i));
        }
        
        return latest_moves;
    }

    public int getCurrentRound()
    {
        return this.current_round;
    }

    /*---------- Other Methods -----*/

    public void addToHistory(Piece piece, int x, int y)
    {
        int[] new_pos = {x, y};
        Move to_add_move = new Move(current_round, new_pos, piece);

        PosList.add(to_add_move);
        current_round++;
    }
}