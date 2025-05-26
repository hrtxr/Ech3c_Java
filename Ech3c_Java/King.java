public class King extends Piece {

    private String color;
    
    /* Setter & getter */
    public King(int x, int y, String color) {
        super(x, y, "K");
        this.color = color;
    }

    public String getCouleur() {
        return this.color;
    }

    /* Methods */
    boolean is_validMove(int position[]) {
        // The king can move 1 square in any direction
        int[] cur_pos = this.getPosition();
        
        return Math.abs(position[0]) == 1 || Math.abs(position[1]) == 1; 

        // Old way
        //return position[0] <= cur_pos[0] +1 || position[0] >= cur_pos[0] -1 || /* top, bottom */
        //       position[1] <= cur_pos[1] +1 || position[1] >= cur_pos[1] -1 || /* left, right */
        //       position[1] <= cur_pos[1] +1 && position[0] <= cur_pos[0] +1 || /* top right */
        //       position[1] >= cur_pos[1] -1 && position[0] >= cur_pos[0] -1 || /* bottom left */
        //       position[1] >= cur_pos[1] -1 && position[0] >= cur_pos[0] +1 || /* bottom right */
        //       position[1] >= cur_pos[1] +1 && position[0] >= cur_pos[0] -1; /* top left */
    }
}
