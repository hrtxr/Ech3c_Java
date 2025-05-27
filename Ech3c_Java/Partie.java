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
}
