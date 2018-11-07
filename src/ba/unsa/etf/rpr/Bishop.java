package ba.unsa.etf.rpr;

public class Bishop extends ChessPiece {
    int i=0;

    private boolean provjeriPomak(String pozicija2){

        int razlikaX = Math.abs(pozicija2.charAt(0) - this.position.charAt(0));
        int razlikaY = Math.abs(pozicija2.charAt(1) - this.position.charAt(1));

        if(Math.abs(razlikaX) == Math.abs(razlikaY)) return true;

        return false;
    }

    Bishop(String pozicija1, Color boja1) {

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