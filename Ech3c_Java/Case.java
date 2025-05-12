public class Case {
    private String couleur_case;
    private Piece piece;

    public Case(String couleur_case) {
        this.couleur_case = couleur_case;
        this.piece = null;
    }

    public boolean isFree() {
        return piece == null;
    }

    public Piece getPiece() {
        return piece;
    }

    public String getCouleurCase() {
        return couleur_case;
    }

    public void setCouleurCase(String couleur_case) {
        this.couleur_case = couleur_case;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}