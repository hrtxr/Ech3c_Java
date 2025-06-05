// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Knight extends Piece {
    
    /* Variables */
    
    /* Setter & getter */
    public Knight(int x, int y, String color) {
        super(x, y, "k", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard) {
        // The rook can move any number of squares horizontally or vertically
        int[] cur_pos = this.getPosition();

        return (
            position[0] <= cur_pos[0] +2 && position[1] >= cur_pos[1] -1 ||
            position[0] <= cur_pos[0] +2 && position[1] >= cur_pos[1] +1 ||

            position[0] >= cur_pos[0] -2 && position[1] <= cur_pos[1] -1 ||
            position[0] >= cur_pos[0] -2 && position[1] <= cur_pos[1] +1 ||

            position[0] <= cur_pos[0] +1 && position[1] >= cur_pos[1] -2 ||
            position[0] <= cur_pos[0] +1 && position[1] >= cur_pos[1] +2 ||

            position[0] >= cur_pos[0] -1 && position[1] <= cur_pos[1] -2 ||
            position[0] >= cur_pos[0] -1 && position[1] <= cur_pos[1] +2 
        );
    }
}
