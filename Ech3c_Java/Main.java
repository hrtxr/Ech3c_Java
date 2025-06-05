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
            // -> Demander à l'utilisateur de sélectionner une destination
            screen.actualise();

            
            // -> Vérifier si la position demandée est valide et gérer les erreurs
            // -> Changer la position de la pièce sélectionnée & supprimer la pièce déjà en place si nécessaire

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
