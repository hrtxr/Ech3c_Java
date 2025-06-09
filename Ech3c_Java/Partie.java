// Created by: Johann Paimboeuf & Romain HEURTAUX

public class Partie extends History {
    private String current_player;
    private Echiquier chessboard;


    public Partie(String current_player) {
        this.current_player = current_player;
        this.chessboard = new Echiquier();
    }

    public String getCurrentPlayer() {
        return current_player;
    }

    public void setCurrentPlayer(String current_player) {
        this.current_player = current_player;
    }


    public String toStringChessboard()
    {
        return this.chessboard.toString();
    }

    public void Move(int startX, int startY, int endX, int endY) {
        // 1. Récupérer la pièce à déplacer
        Case startCase = chessboard.getPlateau()[startX][startY];
        Piece pieceToMove = startCase.getPieceOnIt();

        // Vérifier si une pièce existe à la position de départ
        if (pieceToMove == null) {
            System.out.println("Aucune pièce à déplacer à cette position.");
            return;
        }

        // Recu case dest
        Case endCase = chessboard.getPlateau()[endX][endY];
        Piece pieceAtDestination = endCase.getPieceOnIt();

        // Isvalidmove
         int[] endPosition = {endX, endY};
        if (!pieceToMove.is_validMove(endPosition, chessboard, getCurrentPlayer())) {
            System.out.println("Mouvement invalide pour cette pièce.");
            return;
        }

        // Déplacement
        if (pieceAtDestination == null) {
            // La case de destination est vide
            endCase.setPieceOnIt(pieceToMove);              // Déplacer la pièce vers la case de destination
            startCase.setPieceOnIt(null);       // Vider la case de départ
            pieceToMove.move(endX, endY);                   // Mettre à jour la position de la pièce
        } else {
            endCase.setPieceOnIt(pieceToMove);              // Déplacer la pièce vers la case de destination
            startCase.setPieceOnIt(null);       // Vider la case de départ
            pieceToMove.move(endX, endY);                   // Mettre à jour la position de la pièce
        }

        // Ajout à l'historique (JMLMatheo)
        this.addToHistory(pieceToMove, endX, endY);

    }

    public boolean is_check()
    {
        try
        {
            return this.chessboard.is_check(this.current_player);
        }
        catch(Exception e)
        {
            return false;   // à gérer plus tard
        }
    }
}
