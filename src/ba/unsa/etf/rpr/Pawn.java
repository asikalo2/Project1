package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {

    private boolean provjeriPomak(String pozicija2, Color boja2){
        if(boja2 == Color.WHITE && (pozicija2.charAt(1)-this.position.charAt(1)) != 1) return false;
        if(boja2 == Color.BLACK && (pozicija2.charAt(1)-this.position.charAt(1)) != -1) return false;
        return true;
    }
    Pawn(String pozicija1, Color boja1) {
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
        if(this.getColor() == Color.WHITE){
            if(!provjeriPomak(position, Color.WHITE)) throw new IllegalChessMoveException ("Neispravan potez!");
            this.position=position;
        }
        else {
            if(!provjeriPomak(position, Color.BLACK)) throw new IllegalChessMoveException ("Neispravan potez!");
            this.position=position;
        }
    }
}
