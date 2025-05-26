// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Pawn extends Piece {

    /* Variables */
    private String color;
    
    /* Setter & getter */
    public Pawn(int x, int y, String color) {
        super(x, y, "P");
        this.color = color;
    }

    public String getCouleur() {
        return this.color;
    }

    /* Methods */
    boolean is_validMove(int position[]) {
        // The pawn can move one square forward, or two squares forward from its starting position
        int[] cur_pos = this.getPosition();

        return (
            (position[0] == cur_pos[0]+1 && position[1] == cur_pos[1] + 1) ||
            (position[0] == cur_pos[0]+1 && position[1] == cur_pos[1] - 1)
        );
    }
}
