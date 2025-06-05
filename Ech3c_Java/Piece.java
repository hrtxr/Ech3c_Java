// Created by: Romain HEURTAUX
// Date: 2025-05-07

public abstract class Piece{
    
    /* Variables */
    private int[] position;
    private String letter;
    private String color;
    private String color_escape_seq;

    /* Setter & getter */
    public Piece(int x, int y, String letter) {
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
        this.letter = letter;
        this.color = "White";
        this.addColorEscapeSeq();
    }

    public Piece(int x, int y, String letter, String color) {
        this(x, y, letter);
        this.color = color;
        this.addColorEscapeSeq();
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

    abstract boolean is_validMove(int position[], Echiquier chessboard);
        // Implémenter la logique de validation du mouvement

    public String toString()
    {
            return this.color_escape_seq + this.letter + "\033[1;0m";
            //                                                 ^^^^ -> the default terminal color
            // utiliser la toString plutot que getLetter car on pourra modifier ca plus tard
    }

    /* edit this.color_escape_seq attribute if function of this piece's color */
    private void addColorEscapeSeq()
    {
        this.color_escape_seq = this.color == "Black" ? "\033[1;32m" : "\033[1;37m";
    }
    
}
