public class King extends Piece {

    
    /* Setter & getter */
    public King(int x, int y, String color) {
        super(x, y, "K", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard, String playerColor) {
        // Veryfiying that piece color is corresponding to the player color
        if (!this.getCouleur().equals(playerColor)) {
            return false; 
        }
        
        // The king can move 1 square in any direction
        int[] cur_pos = this.getPosition();
        
        if(!(Math.abs(position[0]) == 1 || Math.abs(position[1]) == 1))
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
