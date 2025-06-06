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

        if(!((position[0] - cur_pos[0] == 0) ^ (position[1] - cur_pos[1] == 0)))
        { 
            //                              ^ = xor 
            return false;
        }

        try {
            if(this.is_piece_on_straight_path(position, chessboard))
            {
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        // Check if the move is either horizontal or vertical
        if (!(position[0] - cur_pos[0] == 0) ^ (position[1] - cur_pos[1] == 0)) {
            return false;
        }

        // Check the color of the destination square
        Piece destinationPiece = chessboard.getPiece(position[0], position[1]);
        if (destinationPiece != null && destinationPiece.getCouleur().equals(this.getCouleur())) {
            return false;
        }

        return true;
    }
}
