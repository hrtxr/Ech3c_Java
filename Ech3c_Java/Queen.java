// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Queen extends Piece {

    /* Variables */
    
    /* Setter & getter */
    public Queen(int x, int y, String color) {
        super(x, y, "Q", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard) {
        // The queen can move any number of squares in any direction
        int[] cur_pos = this.getPosition();

        if(!(Math.abs( position[0] - cur_pos[0]) == Math.abs(position[1] - cur_pos[1])) &&      // not Diagonal movement 
        !(position[0] - cur_pos[0] == 0 || position[1] - cur_pos[1] == 0))                      // not Horizontal or vertical movement
        {
            return false;
        }

        if(this.is_piece_on_diagonal_path(position, chessboard))
        {
            return false;
        }

        return true;
    }
}