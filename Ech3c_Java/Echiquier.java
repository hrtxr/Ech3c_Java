public class Echiquier {
    private Case[][] Plateau = new Case[8][8];

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
}
