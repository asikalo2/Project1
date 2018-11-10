package ba.unsa.etf.rpr;

public class King extends ChessPiece {

   /* private boolean provjeriPomak(String pozicija2){
        if(((pozicija2.charAt(1)-this.position.charAt(1)) != 2) || ((pozicija2.charAt(1)-this.position.charAt(1)) != -2)) {
            return false; }
        return true;
    }
*/
   private boolean provjeriPomak(String pozicija2){

       int razlikaX = Math.abs(pozicija2.charAt(0) - this.position.charAt(0));
       int razlikaY = Math.abs(pozicija2.charAt(1) - this.position.charAt(1));

       if ((razlikaX == 1 && razlikaY == 1) ||  (razlikaX == 0 && razlikaY == 1) ||
               (razlikaX == 1 && razlikaY == 0))  return true;

       return false;
   }
    King(String pozicija1, Color boja1) {
        super(pozicija1, boja1);

        if (pozicija1.equals("")) throw new IllegalArgumentException("Neispravan unos!");
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
