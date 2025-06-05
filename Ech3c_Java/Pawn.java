// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Pawn extends Piece {

    /* Variables */


    /* Setter & getter */
    public Pawn(int x, int y, String color) {
        super(x, y, "P", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard) {
        // The pawn can move one square forward, or two squares forward from its starting position
        int[] cur_pos = this.getPosition();
        if (this.getCouleur()=="Black"){
                return (position[0] == cur_pos[0]+1);
        } else {
                return (position[0] == cur_pos[0]-1);
        }

        //(position[0] == cur_pos[0]+1 && position[1] == cur_pos[1] + 1) ||
        //(position[0] == cur_pos[0]+1 && position[1] == cur_pos[1] - 1));
    }
}
