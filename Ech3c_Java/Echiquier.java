public class Echiquier {
    private Case[][] Plateau;

    public Echiquier() {
        Plateau = new Case[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Plateau[i][j] = new Case(null); // Empty cases
            }
        }
    }

    public Echiquier()
    {
        for(int i = 0; i < Plateau.length; i++)
        {
            for(int j = 0; j < Plateau[i].length; j++)
            {
                Plateau[i][j] = new Case();
            }
        }
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
}
