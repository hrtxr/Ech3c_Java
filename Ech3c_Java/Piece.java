// Created by: Romain HEURTAUX
// Date: 2025-05-07

public abstract class Piece{
    
    /* Variables */
    private int[] position;
    private String letter;
    private String color;

    /* Setter & getter */
    public Piece(int x, int y, String letter) {
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
        this.letter = letter;
        this.color = "White";
    }

    public Piece(int x, int y, String letter, String color) {
        this(x, y, letter);
        this.color = color;
    }

    public int[] getPosition() {
        int[] cur_pos = new int[2];
        cur_pos[0] = this.position[0];
        cur_pos[1] = this.position[1];
        return cur_pos;
    }

    public String getLetter() {
        return this.letter;
    }

    public String getCouleur() {
        return this.color;
    }

    /* Methods */
    public void move(int x, int y) {
        try {
            this.position[0] = x;
            this.position[1] = y;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Move");
        }
    }

    abstract boolean is_validMove(int position[]);
        // Implémenter la logique de validation du mouvement

    public String toString()
    {
            return this.letter; // utiliser la toString plutot que getLetter car on pourra modifier ca plus tard
        }
    
}
