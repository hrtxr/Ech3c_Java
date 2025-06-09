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
        String[] line_letters = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for(int i = 0; i < Plateau.length; i++)
        {
            chessboard_str = chessboard_str.concat(line_letters[i]);
            chessboard_str = chessboard_str.concat("  ");
            for(int j = 0; j < Plateau[i].length; j++)
            {
                chessboard_str = chessboard_str.concat(this.Plateau[i][j].toString());
                chessboard_str = chessboard_str.concat(" ");
            }
            chessboard_str = chessboard_str.concat("\n");
        }

        chessboard_str = chessboard_str.concat("   ");
        for(int i = 1; i < 8 + 1; i++)
        {
            chessboard_str = chessboard_str.concat(Integer.toString(i));
            chessboard_str = chessboard_str.concat(" ");
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

    /*  Determine si le roi du joueur passé en argument est en position d'échec.
        Algorithme :
            Parcours toute les case de l'échiquier. Si la pièce est de la couleur adverse et qu'elle peut se déplacer jusqu'au Roi
            (et donc le manger), alors notre Roi est en position d'échec.
        Args :
            String player_color :   current player's color
        Returns :
            boolean : true if current player's king is in check position
    */
    public boolean is_check(String player_color) throws Exception
    {
        String adverse_color = player_color == "White" ? "Black" : "White";
        Piece player_king = null;
        int[] player_king_position;
        Piece current_piece;
        boolean found = false;
        int i = 0;
        int j = 0;

        // recherche du Roi du joueur actuel
        while(i < Plateau.length && !found)
        {
            j = 0;
            while(j < Plateau[i].length && !found)
            {   
                current_piece = Plateau[i][j].getPieceOnIt();
                if(current_piece != null)
                {
                    if( current_piece.getLetter().equals("K")    // si la piece est le Roi du joueur actuel
                        && current_piece.getCouleur() == player_color
                    ) 
                    {
                        player_king = current_piece;    // /!\ pas d'encapsulation ici, c'est pas une nouvelle instance
                        found = true;
                    }
                }
                j++;
            }
            i++;
        }

        if(player_king != null)
        {
            player_king_position = player_king.getPosition();
        }
        else
        {
            throw new Exception("Le Roi n'a pas été trouvé");   // normalement ne se produit jamais
        }

        //  recherche si une piece adverse peut atteindre la position du Roi (donc le manger),
        //  et donc le met en echec
        for(i = 0; i < Plateau.length; i++)
        {
            for(j = 0; j < Plateau[i].length; j++)
            {
                current_piece = Plateau[i][j].getPieceOnIt();
                if(current_piece != null)
                {
                    if(current_piece.is_validMove(player_king_position, this, adverse_color)
                        && current_piece.getCouleur().equals(adverse_color)
                        && !(current_piece.getLetter().equals("k"))
                    )
                    {
                        // la piece peut manger le Roi. Donc il y a echec.
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* Return the index on the matrix of the string coordinates.
    For example :   "B8" -> (0, 1)
                    "D6" -> (2, 3)
    */
    public static int[] coord_str_to_int(String coordinates) throws IllegalArgumentException
    {
        if(coordinates.length() > 2)  // vérification des entrées
        {
            throw new IllegalArgumentException("La chaine de caractère est trop longue");
        }

        char[] letters_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char letter = coordinates.charAt(0);
        char number_str = coordinates.charAt(1);
        int number_int = Character.getNumericValue(number_str); // we use Character object methods
        int[] matrix_coord = new int[2];                        // documentation here : https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
        boolean searching_letter = true;
        int i;

        letter = Character.toUpperCase(letter);     // just for sure

        matrix_coord[1] = number_int - 1;   // y coord

        i = 0;
        while(i < letters_array.length && searching_letter) // searching maching letter's index for the x coord
        {
            if(letters_array[i] == letter)
            {
                matrix_coord[0] = i;
                searching_letter = false;
            }
            i++;
        }

        return matrix_coord;
    }
}
