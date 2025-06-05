// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Bishop extends Piece {

    /* Variables */
    
    /* Setter & getter */
    public Bishop(int x, int y, String color) {
        super(x, y, "B", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard) {
        // The bishop can move any number of squares diagonally
        int[] cur_pos = this.getPosition();

        // Check if the move is diagonal
        if (Math.abs(position[0] - cur_pos[0]) != Math.abs(position[1] - cur_pos[1])) {
            return false;
        }

        // Determine direction
        int xDirection;
        if ((position[0] - cur_pos[0]) > 0) {xDirection = 1;} else { xDirection = -1;}
        int yDirection;
        if ((position[1] - cur_pos[1]) > 0) { yDirection = 1; } else { yDirection = -1; }

        // Check each square along the path for obstacles
        int x = cur_pos[0]+xDirection;
        int y = cur_pos[1]+yDirection;
        System.out.println(" x: " + x + " y: " + y);
        while (x != position[0] && y != position[1]) {
            if (chessboard.getPiece(x, y) != null) {
                return false; 
            }
            x += xDirection;
            y += yDirection;
        }

        return true; // The path is clear and the move is valid
    }
}
