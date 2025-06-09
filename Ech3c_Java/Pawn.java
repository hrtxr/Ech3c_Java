// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Pawn extends Piece {

    /* Variables */


    /* Setter & getter */
    public Pawn(int x, int y, String color) {
        super(x, y, "P", color);
    }

    /* Methods */
    boolean is_validMove(int position[], Echiquier chessboard, String playerColor) {
        // Vérifie que la couleur de la pièce correspond à celle du joueur
        if (!this.getCouleur().equals(playerColor)) {
            return false; // La pièce ne peut pas être bougée par ce joueur
        }

        int[] cur_pos = this.getPosition();
        if (this.getCouleur().equals("Black")) {
            
            // Si l'historique contient 1 ou 2 éléments, le pion peut avancer de deux cases
            if (chessboard.history.size() <= 2) {
                if (position[0] == cur_pos[0] + 2 && position[1] == cur_pos[1] &&
                    chessboard.getPiece(position[0], position[1]) == null &&
                    chessboard.getPiece(cur_pos[0] + 1, position[1]) == null) {
                    return true; 
                }
            }

            // mouvement vers le bas
            if (cur_pos[1] == 0) { // Si le pion est tout à gauche
                if (position[0] == cur_pos[0] + 1 && position[1] == cur_pos[1] + 1 &&
                    chessboard.getPiece(position[0], position[1]) != null &&
                    !chessboard.getPiece(position[0], position[1]).getCouleur().equals("Black")) {
                    return true; // Capture diagonale
                }
            } else if (cur_pos[1] == 7) { // Si le pion est tout à droite
                if (position[0] == cur_pos[0] + 1 && position[1] == cur_pos[1] - 1 &&
                    chessboard.getPiece(position[0], position[1]) != null &&
                    !chessboard.getPiece(position[0], position[1]).getCouleur().equals("Black")) {
                    return true; // Capture diagonale
                }
            } else {
                if ((position[0] == cur_pos[0] + 1 && position[1] == cur_pos[1] + 1 ||
                     position[0] == cur_pos[0] + 1 && position[1] == cur_pos[1] - 1) &&
                    chessboard.getPiece(position[0], position[1]) != null &&
                    !chessboard.getPiece(position[0], position[1]).getCouleur().equals("Black")) {
                    return true; // Capture diagonale
                }
            }

            // Sinon, le pion avance tout droit
            if (position[0] == cur_pos[0] + 1 && position[1] == cur_pos[1] &&
                chessboard.getPiece(position[0], position[1]) == null &&
                this.getCouleur().equals("Black")) {
                return true; // Avance tout droit
            }
        } else {
            // Si l'historique contient 1 ou 2 éléments, le pion peut avancer de deux cases
            if (chessboard.history.size() <= 2) {
                if (position[0] == cur_pos[0] - 2 && position[1] == cur_pos[1] &&
                    chessboard.getPiece(position[0], position[1]) == null &&
                    chessboard.getPiece(cur_pos[0] - 1, position[1]) == null) {
                    return true;
                }
            }
        
            // mouvement vers le haut
            if (cur_pos[1] == 0) { // Si le pion est tout à gauche
                if (position[0] == cur_pos[0] - 1 && position[1] == cur_pos[1] + 1 &&
                    chessboard.getPiece(position[0], position[1]) != null &&
                    !chessboard.getPiece(position[0], position[1]).getCouleur().equals("White")) {
                    return true; // Capture diagonale
                }
            } else if (cur_pos[1] == 7) { // Si le pion est tout à droite
                if (position[0] == cur_pos[0] - 1 && position[1] == cur_pos[1] - 1 &&
                    chessboard.getPiece(position[0], position[1]) != null &&
                    !chessboard.getPiece(position[0], position[1]).getCouleur().equals("White")) {
                    return true; // Capture diagonale
                }
            } else {
                if ((position[0] == cur_pos[0] - 1 && position[1] == cur_pos[1] + 1 ||
                     position[0] == cur_pos[0] - 1 && position[1] == cur_pos[1] - 1) &&
                    chessboard.getPiece(position[0], position[1]) != null &&
                    !chessboard.getPiece(position[0], position[1]).getCouleur().equals("White")) {
                    return true; // Capture diagonale
                }
            }

            // Sinon, le pion avance tout droit
            if (position[0] == cur_pos[0] - 1 && position[1] == cur_pos[1] &&
                chessboard.getPiece(position[0], position[1]) == null &&
                this.getCouleur().equals("White")) {
                return true; // Avance tout droit
            }
        }
        return false;
    }
}
