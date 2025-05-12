public class Echiquier {
    private Case[][] Plateau = new Case[8][8];

    public Case[][] getPlateau() {
        return Plateau;
    }

    public void setPlateau(Case[][] Plateau) {
        this.Plateau = Plateau;
    }
}
