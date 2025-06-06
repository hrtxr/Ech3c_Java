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

        if(this.is_piece_on_diagonal_path(position, chessboard))
        {
            return false;
        }

        // Check the color of  the destination square
        Piece destinationPiece = chessboard.getPiece(position[0], position[1]);
        if (destinationPiece != null && destinationPiece.getCouleur().equals(this.getCouleur())) {
            return false;
        }

        return true; 
    }
}
