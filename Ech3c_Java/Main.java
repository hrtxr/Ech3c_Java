public class Main {
    public static void main(String[] args) {
        // Initialize the game
        Partie game = new Partie("White");

        Screen screen = new Screen(game);
        
        // Start the game loop
        while (true) {
            System.out.println("Current player: " + game.getCurrentPlayer());
            screen.actualise();
        }
    }
}
