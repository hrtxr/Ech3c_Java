// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Bishop extends Piece {

    /* Setter & getter */
    public Bishop(int x, int y, String color) {
        super(x, y, "B", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard, String playerColor) {
        // veryfiying that piece color is corresponding to the player color
        if (!this.getCouleur().equals(playerColor)) {
            return false; 
        }
        
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
        while (x != position[0] && y != position[1]) {
            if (chessboard.getPiece(x, y) != null) {
                return false; 
            }
            x += xDirection;
            y += yDirection;
        }

        // Check the color of  the destination square
        Piece destinationPiece = chessboard.getPiece(position[0], position[1]);
        if (destinationPiece != null && destinationPiece.getCouleur().equals(this.getCouleur())) {
            return false;
        }

        return true; 
    }
}
