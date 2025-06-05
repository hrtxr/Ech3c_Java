// Created by: Romain HEURTAUX
// Date: 2025-05-26

public class Main {
    public static void main(String[] args) {
        // Initialize the game
        Partie game = new Partie("White");

        Screen screen = new Screen(game);
        Boolean Game = true;

        // Start the game loop
        while (Game) {
            // -> Afficher l'état du jeu (grille avec les pièces)
            // -> Demander à l'utilisateur de sélectionner une pièce
            int[][] user_move;
            user_move = screen.actualise();
            // -> Demander à l'utilisateur de sélectionner une destination

            
            // -> Vérifier si la position demandée est valide et gérer les erreurs
            // -> Changer la position de la pièce sélectionnée & supprimer la pièce déjà en place si nécessaire
            game.Move(user_move[0][0], user_move[0][1], user_move[1][0], user_move[1][1]);

            // Vérifier si la partie est terminée
            /*if (game.isFinished()) {
                Game = false;
            }*/

            // -> Changer de joueur
            if (game.getCurrentPlayer() == "White"){
                game.setCurrentPlayer("Black");
            } else {
                game.setCurrentPlayer("White");
            }
        }
    }
}
