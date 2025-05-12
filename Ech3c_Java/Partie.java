public class Partie {
    private String current_player;

    public Partie(String current_player) {
        this.current_player = current_player;
    }

    public String getCurrentPlayer() {
        return current_player;
    }

    public void setCurrentPlayer(String current_player) {
        this.current_player = current_player;
    }
}
