public class King extends Piece {
    private String color;
    
    public King(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public String getCouleur() {
        return this.color;
    }

    boolean is_validMove(int position[]) {
        // Implémenter la logique de validation du mouvement pour le roi
        // The king can move 1 square in any direction
        int[] cur_pos = this.getPosition();
        return Math.abs(position[0]) == 1 || Math.abs(position[1]) == 1; 

        // Old way
        //return position[0] <= cur_pos[0] +1 || position[0] >= cur_pos[0] -1 || /* haut, bas */
        //       position[1] <= cur_pos[1] +1 || position[1] >= cur_pos[1] -1 || /* gauche, droite */
        //       position[1] <= cur_pos[1] +1 && position[0] <= cur_pos[0] +1 || /* haut droite */
        //       position[1] >= cur_pos[1] -1 && position[0] >= cur_pos[0] -1 || /* bas gauche */
        //       position[1] >= cur_pos[1] -1 && position[0] >= cur_pos[0] +1 || /* bas droite */
        //       position[1] >= cur_pos[1] +1 && position[0] >= cur_pos[0] -1; /* haut gauche */
    }
}
