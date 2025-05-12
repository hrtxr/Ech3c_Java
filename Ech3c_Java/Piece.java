public class Piece extends Case{
    private int[] position;x

    public Piece(int x, int y) {
        super(x,y);
        this.position = new int[2];
        this.position[0] = x;
        this.position[1] = y;
    }

    public void move(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    function getPosition() {
        return this.position;
    }
}