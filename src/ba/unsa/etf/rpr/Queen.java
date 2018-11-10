package ba.unsa.etf.rpr;

public class Queen extends ChessPiece {

    private boolean provjeriPomak(String pozicija2){

        int razlikaX = Math.abs(pozicija2.charAt(0) - this.position.charAt(0));
        int razlikaY = Math.abs(pozicija2.charAt(1) - this.position.charAt(1));

        if(Math.abs(razlikaX) == Math.abs(razlikaY)) return true;

        if(razlikaX == 0){
            if(razlikaY != 0) return true;
        }

        if(razlikaY == 0){
            if(razlikaX != 0) return true;
        }

        if ((razlikaX == 1 && razlikaY == 1) ||  (razlikaX == 0 && razlikaY == 1) ||
                (razlikaX == 1 && razlikaY == 0))  return true;



        return false;
    }


    Queen(String pozicija1, Color boja1) {

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
