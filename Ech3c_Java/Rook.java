// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Rook extends Piece {
    
    /* Variables */
    
    /* Setter & getter */
    public Rook(int x, int y, String color) {
        super(x, y, "R", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard, String playerColor) {
        // veryfiying that piece color is corresponding to the player color
        if (!this.getCouleur().equals(playerColor)) {
            return false;
        }
        
        // The rook can move any number of squares horizontally or vertically
        int[] cur_pos = this.getPosition();

        // Check if the move is either horizontal or vertical
        if (!(position[0] - cur_pos[0] == 0) ^ (position[1] - cur_pos[1] == 0)) {
            return false;
        }

        // Check for obstacles in the path
        int xDirection = 0;
        int yDirection = 0;

        if (position[0] > cur_pos[0]) {
            xDirection = 1;
        } else if (position[0] < cur_pos[0]) {xDirection = -1;}

        if (position[1] > cur_pos[1]) {yDirection = 1;} else if (position[1] < cur_pos[1]) {yDirection = -1;}

        int x = cur_pos[0] + xDirection;
        int y = cur_pos[1] + yDirection;
        while (x != position[0] || y != position[1]) {
            if (chessboard.getPiece(x, y) != null) {
                return false; 
            }
            x += xDirection;
            y += yDirection;
        }

        // Check the color of the destination square
        Piece destinationPiece = chessboard.getPiece(position[0], position[1]);
        if (destinationPiece != null && destinationPiece.getCouleur().equals(this.getCouleur())) {
            return false;
        }

        return true;
    }
}
