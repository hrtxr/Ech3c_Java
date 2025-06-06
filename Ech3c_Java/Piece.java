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

    /*  Determine s'il y a une piece sur le déplacement en diagonal. 
        Copié collé du code de Romain Heurtaux (depuis une autre classe du programme).
        Args :
            int position[]  : array of 2 integers what contains the move that we want to check
            Echiquier chessboard : instance of the current chessboard
        Returns :
            boolean : true if there is a piece on path, if not, false
    */ 
    public boolean is_piece_on_diagonal_path(int position[], Echiquier chessboard)
    {
        int[] cur_pos = this.getPosition();

        // Determine direction
        int xDirection;
        if ((position[0] - cur_pos[0]) > 0) {xDirection = 1;} else { xDirection = -1;}
        int yDirection;
        if ((position[1] - cur_pos[1]) > 0) { yDirection = 1; } else { yDirection = -1; }

        // Check each square along the path for obstacles
        int x = cur_pos[0]+xDirection;
        int y = cur_pos[1]+yDirection;
        while (x != position[0] && y != position[1]) {
            if (chessboard.getPiece(x, y) != null) {
                return true; 
            }
            x += xDirection;
            y += yDirection;
        }
        return false;
    }

    /*  Determine s'il y a une piece sur le déplacement en ligne droite. 
        Args :
            int position[]  : array of 2 integers what contains the move that we want to check
            Echiquier chessboard : instance of the current chessboard
        Returns :
            boolean : true if there is a piece on path, if not, false
    */ 
    public boolean is_piece_on_straight_path(int position[], Echiquier chessboard) throws Exception
    {
        int[] cur_pos = this.getPosition();

        // Determine direction
        int xDirection;
        if ((position[0] - cur_pos[0]) > 0) {xDirection = 1;} else { xDirection = -1;}
        int yDirection;
        if ((position[1] - cur_pos[1]) > 0) { yDirection = 1; } else { yDirection = -1; }

        if(xDirection != 0 && yDirection != 0)
        {
            throw new Exception("Le déplacement n'est pas en ligne droite.");
        }

        // Check each square along the path for obstacles
        int x = cur_pos[0]+xDirection;
        int y = cur_pos[1]+yDirection;
        while (x != position[0] && y != position[1]) {
            if (chessboard.getPiece(x, y) != null) {
                return true; 
            }
            x += xDirection;
            y += yDirection;
        }
        return false;
    }
    
    
}