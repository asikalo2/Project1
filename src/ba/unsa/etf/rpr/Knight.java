package ba.unsa.etf.rpr;

public class Knight extends ChessPiece {

    private boolean provjeriPomak(String pozicija2){

        int razlikaX = Math.abs(pozicija2.charAt(0) - this.position.charAt(0));
        int razlikaY = Math.abs(pozicija2.charAt(1) - this.position.charAt(1));

        if ((razlikaX == 2 && razlikaY == 1) || (razlikaX == 1 && razlikaY == 2))
            return true;

        return false;
    }

    Knight(String pozicija1, Color boja1) {
        super(pozicija1, boja1);
    }

    @Override
    public String getPosition() {
        return this.position;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void move(String position) {
        if (this.position.equals(position))
            return;
        if (!ispravnostPozicije(position)) throw new IllegalArgumentException("Neispravna pozicija!");
        if(!provjeriPomak(position)) throw new IllegalChessMoveException ("Neispravan potez!");
        this.position=position;
    }
}
