// Created by: Romain HEURTAUX
// Date: 2025-05-07

public abstract class Piece{
    
    /* Variables */
    private int[] position;

    /* Setter & getter */
    public Piece(int x, int y) {
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
    }
    public int[] getPosition() {
        int[] cur_pos = new int[2];
        cur_pos[0] = this.position[0];
        cur_pos[1] = this.position[1];
        return cur_pos;
    }

    /* Méthodes */
    public void move(int x, int y) {
        try {
            this.position[0] = x;
            this.position[1] = y;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Move");
        }
    }


    abstract boolean is_validMove() {
        // Implémenter la logique de validation du mouvement

    }
}
