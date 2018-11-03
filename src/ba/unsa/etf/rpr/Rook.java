package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {

    private boolean provjeriPomak(String pozicija2){

        if(pozicija2.charAt(0) != this.position.charAt(0)) return false;

        return true;
    }

    Rook(String pozicija1, Color boja1) {
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
        if (!ispravnostPozicije(position)) throw new IllegalArgumentException("Neispravna pozicija!");
        if(!provjeriPomak(position)) throw new IllegalChessMoveException ("Neispravan potez!");
        this.position=position;
    }
}
