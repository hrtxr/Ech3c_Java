// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Rook extends Piece {
    
    /* Variables */
    
    /* Setter & getter */
    public Rook(int x, int y, String color) {
        super(x, y, "R", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard) {
        // The rook can move any number of squares horizontally or vertically
        int[] cur_pos = this.getPosition();

        return (position[0] - cur_pos[0] == 0) ^ (position[1] - cur_pos[1] == 0); 
        //                                  ^ = xor 
    }
}
