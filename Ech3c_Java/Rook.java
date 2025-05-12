// Created by: Romain HEURTAUX
// Date: 2025-05-12

public class Rook extends Piece {
    
    /* Variables */
    private String color;
    
    /* Setter & getter */
    public Rook(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public String getCouleur() {
        return this.color;
    }

    /* Méthodes */
    boolean is_validMove(int position[]) {
        // Implémenter la logique de validation du mouvement pour le roi
        // The king can move 1 square in any direction
        int[] cur_pos = this.getPosition();

        return Math.abs(position[0]) >= 1 || (Math.abs(position[1]) == 1);  
    }
}
