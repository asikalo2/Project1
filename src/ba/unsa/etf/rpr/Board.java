package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<ChessPiece> spisak_figura = new ArrayList<ChessPiece>();

    public Board() {
        spisak_figura.add(new Rook("A1", ChessPiece.Color.WHITE));
        spisak_figura.add(new Rook("H1", ChessPiece.Color.WHITE));
        spisak_figura.add(new Bishop("C1", ChessPiece.Color.WHITE));
        spisak_figura.add(new Bishop("F1", ChessPiece.Color.WHITE));
        spisak_figura.add(new Knight("B1", ChessPiece.Color.WHITE));
        spisak_figura.add(new Knight("G1", ChessPiece.Color.WHITE));
        spisak_figura.add(new King("E1", ChessPiece.Color.WHITE));
        spisak_figura.add(new Queen("D1", ChessPiece.Color.WHITE));
        spisak_figura.add(new Pawn("A2", ChessPiece.Color.WHITE));
        spisak_figura.add(new Pawn("B2", ChessPiece.Color.WHITE));
        spisak_figura.add(new Pawn("C2", ChessPiece.Color.WHITE));
        spisak_figura.add(new Pawn("D2", ChessPiece.Color.WHITE));
        spisak_figura.add(new Pawn("E2", ChessPiece.Color.WHITE));
        spisak_figura.add(new Pawn("F2", ChessPiece.Color.WHITE));
        spisak_figura.add(new Pawn("G2", ChessPiece.Color.WHITE));
        spisak_figura.add(new Pawn("H2", ChessPiece.Color.WHITE));

        spisak_figura.add(new Rook("A8", ChessPiece.Color.BLACK));
        spisak_figura.add(new Rook("H8", ChessPiece.Color.BLACK));
        spisak_figura.add(new Bishop("C8", ChessPiece.Color.BLACK));
        spisak_figura.add(new Bishop("F8", ChessPiece.Color.BLACK));
        spisak_figura.add(new Knight("B8", ChessPiece.Color.BLACK));
        spisak_figura.add(new Knight("G8", ChessPiece.Color.BLACK));
        spisak_figura.add(new King("E8", ChessPiece.Color.BLACK));
        spisak_figura.add(new Queen("D8", ChessPiece.Color.BLACK));
        spisak_figura.add(new Pawn("A7", ChessPiece.Color.BLACK));
        spisak_figura.add(new Pawn("B7", ChessPiece.Color.BLACK));
        spisak_figura.add(new Pawn("C7", ChessPiece.Color.BLACK));
        spisak_figura.add(new Pawn("D7", ChessPiece.Color.BLACK));
        spisak_figura.add(new Pawn("E7", ChessPiece.Color.BLACK));
        spisak_figura.add(new Pawn("F7", ChessPiece.Color.BLACK));
        spisak_figura.add(new Pawn("G7", ChessPiece.Color.BLACK));
        spisak_figura.add(new Pawn("H7", ChessPiece.Color.BLACK));
    }

    public boolean praznoPolje(String s) {
        int i = 0;

        for (i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).equals(s)) return false;
        }
        return true;
    }

    public boolean preskaceFigure(String pocetnaPozicija, String krajnjaPozicija){
        int i=0;

        int pX = pocetnaPozicija.charAt(0)-'A';
        int pY =  pocetnaPozicija.charAt(1)-'1';
        int kX = krajnjaPozicija.charAt(0)-'A';
        int kY =  krajnjaPozicija.charAt(1)-'1';
        int dX = kX - pX;
        int dY = kY - pY;
        int incX = 0, incY = 0;
        if (dX > 0)
            incX = 1;
        else if (dX < 0)
            incX = -1;

        if (dY > 0)
            incY = 1;
        else if(dY < 0)
            incY = -1;

        while (pX != kX && pY != kY){
            pX += incX;
            pY += incY;
            String temp = "A1";
            char[] t = temp.toCharArray(); t[0]= 'A'; t[1]= '1';
            String trenutnaPozicija = String.valueOf(t);
            if (!praznoPolje(trenutnaPozicija))
                return true;
        }
        return false;
    }

    public int indeksTrazeneFigureUListi(String e){
        int indeks=0;
        int i=0;

        for (i=0; i < spisak_figura.size();  i++){
            if(spisak_figura.get(i).equals(e)) {
                indeks = i;
            }
        }
        return indeks;
    }

    public List<ChessPiece> getSpisak_figura() {

        return spisak_figura;
    }

    public void setSpisak_figura(List<ChessPiece> spisak_figura) {

        this.spisak_figura = spisak_figura;
    }

    public boolean isCheck(ChessPiece.Color boja) {
        int i=0;

        if(boja.equals(ChessPiece.Color.WHITE)){
            for (i=0; i < spisak_figura.size();  i++) {
                if (spisak_figura.get(i).equals(boja)) return true;
            }
        }

        else if (boja.equals(ChessPiece.Color.WHITE)){
            for (i=0; i < spisak_figura.size();  i++) {
                if (spisak_figura.get(i).equals(boja)) return true;
            }
        }
        return false;
    }


    public void move(Class Chesspiece, ChessPiece.Color white, String e4) {
        int i=0;

        for (i=0; i < spisak_figura.size();  i++){
            if(spisak_figura.get(i).equals(Chesspiece)){
                spisak_figura.get(i).move(e4);
                //   if(legalanPoziv(spisak_figura.get(i))) throw new IllegalChessMoveException ("Greška!");

            }
        }

    }

    public void move(String e2, String e) {
        int i=0;
        int ind1 = 0;
        int ind2 = 0;
        ind1 = indeksTrazeneFigureUListi(e2);
        ind2 = indeksTrazeneFigureUListi(e);

        if(!praznoPolje(e2)) throw new IllegalArgumentException ("Greška!");
        if(preskaceFigure(e2,e)) throw new IllegalChessMoveException("Preskače figure");

        for (i=0; i < spisak_figura.size();  i++){
            if(!praznoPolje(e)){
                spisak_figura.get(ind1).move(e2); //pomjeramo figuru na novo mjesto
                spisak_figura.remove(ind2);// jede se figura koja je bila na starom mjestu
            }
           else {
               spisak_figura.get(ind1).move(e2);
           }
        }
    }


}
