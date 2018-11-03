package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    public static enum Color {BLACK, WHITE};

    protected String position;
    protected Color color;

    protected boolean ispravnostPozicije(String pozicija2) {
        if ((pozicija2.charAt(0) < 'A' || pozicija2.charAt(0) > 'H') ||
                (pozicija2.charAt(1) < '1' || pozicija2.charAt(1) > '8'))
            return false;
        return true;
    }

    ChessPiece(String pozicija1, Color boja1) {
        this.position = pozicija1;
        this.color = boja1;

        if (!ispravnostPozicije(pozicija1))
            throw new IllegalArgumentException("Neispravna pozicija!");

    }

    public abstract String getPosition();

    public abstract Color getColor();

    public abstract void move(String position);

}
