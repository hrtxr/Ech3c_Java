public class Echiquier {
    private Case[][] Plateau;

    public Echiquier()
    {
        this.Plateau = new Case[8][8];
        for(int i = 0; i < this.Plateau.length; i++)
        {
            for(int j = 0; j < this.Plateau[i].length; j++)
            {
                this.Plateau[i][j] = new Case();    // Empty cases
            }
        }

        this.init_pieces();
    }

    public Case[][] getPlateau() {
        return Plateau;
    }

    public void setPlateau(Case[][] Plateau) {
        this.Plateau = Plateau;
    }

    public String toString()
    {
        String chessboard_str = new String();
        for(int i = 0; i < Plateau.length; i++)
        {
            for(int j = 0; j < Plateau[i].length; j++)
            {
                chessboard_str = chessboard_str.concat(this.Plateau[i][j].toString());
                chessboard_str = chessboard_str.concat(" ");
            }
            chessboard_str = chessboard_str.concat("\n");
        }

        return chessboard_str;
    }

    public Piece getPiece(int x, int y)
    {
        return Plateau[x][y].getPieceOnIt();
    }

    public void setPiece(int x, int y, Piece p)
    {
        Plateau[x][y].setPieceOnIt(p);

    }

    /* Used to place all the pieces at their standard position at the begining of the game. */
    private void init_pieces()
    {
        int x = 0;                      //          THE CHESSBOARD 
        int y = 0;                      // 0 [[A8, B8, C8, D8, E8, F8, G8, H8],
                                        // 1  [A7, B7, C7, D7, E7, F7, G7, H7],
                                        // 2  [A6, B6, C6, D6, E6, F6, G6, H6],
                                        // 3  [A5, B5, C5, D5, E5, F5, G5, H5],
                                        // 4  [A4, B4, C4, D4, E4, F4, G4, H4],
                                        // 5  [A3, B3, C3, D3, E3, F3, G3, H3],
                                        // 6  [A2, B2, C2, D3, E3, F3, G3, H3],
                                        // 7  [A1, B1, C1, D1, E1, F1, G1, H1]]
                                        //      0   1   2   3   4   5   6   7

        // place all the pawns
        for(int i = 0; i < 8; i++)
        {
            x = 1;
            y = i;
            Piece current_pawn = new Pawn(x, y, "Black");
            this.Plateau[x][y].setPieceOnIt(current_pawn);

            x = 6;  // 7 - 1 = 6 where 7 is the last line of case, so 6 is the penultimate one
            current_pawn = new Pawn(x, y, "White");
            this.Plateau[x][y].setPieceOnIt(current_pawn);
        }

        // place the rooks
        for(int i = 0; i <= 7; i = i + 7)
        {                                       // les indices font toutes les 2-combinaison sur {0, 7}
            for(int j = 0; j <= 7; j = j + 7)   // soit tout les coins de l'échiquier
            {
                x = i;
                y = j;
                Piece current_rook = new Rook(x, y, i == 0 ? "Black" : "White"); // noir si on est sur la premiere ligne
                this.Plateau[x][y].setPieceOnIt(current_rook);
            }
        }

        // place the knights
        for(int i = 1; i <= 6; i = i + 5)   // i takes values of 1 and 6 (only that ones)
        {
            x = 0;
            y = i;
            Piece current_knight = new Knight(x, y, "Black");
            this.Plateau[x][y].setPieceOnIt(current_knight);

            x = 7;
            current_knight = new Knight(x, y, "White");
            this.Plateau[x][y].setPieceOnIt(current_knight);
        }

        // place the bishops
        for(int i = 2; i <= 5; i = i + 3)   // i takes values of 2 and 5 (only that ones)
        {
            x = 0;
            y = i;
            Piece current_bishop = new Bishop(x, y, "Black");
            this.Plateau[x][y].setPieceOnIt(current_bishop);

            x = 7;
            current_bishop = new Bishop(x, y, "White");
            this.Plateau[x][y].setPieceOnIt(current_bishop);
        }

        // place the queens
        x = 0;
        y = 3;
        Piece current_queen = new Queen(x, y, "Black");
        this.Plateau[x][y].setPieceOnIt(current_queen);

        x = 7;
        current_queen = new Queen(x, y, "White");
        this.Plateau[x][y].setPieceOnIt(current_queen);

        // place the kings
        x = 0;
        y = 4;
        Piece current_king = new King(x, y, "Black");
        this.Plateau[x][y].setPieceOnIt(current_king);

        x = 7;
        current_king = new King(x, y, "White");
        this.Plateau[x][y].setPieceOnIt(current_king);
    }
}
