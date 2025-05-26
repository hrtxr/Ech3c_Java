// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Bishop extends Piece {

    /* Variables */
    private String color;
    
    /* Setter & getter */
    public Bishop(int x, int y, String color) {
        super(x, y, "B");
        this.color = color;
    }

    public String getCouleur() {
        return this.color;
    }

    /* Methods */
    boolean is_validMove(int position[]) {
        // The bishop can move any number of squares diagonally
        int[] cur_pos = this.getPosition();

        return (Math.abs( position[0] - cur_pos[0]) == Math.abs(position[1] - cur_pos[1]));        // Diagonal movement 
    }
}
