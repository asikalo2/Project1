package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<ChessPiece> spisak_figura = new ArrayList<ChessPiece>();

    public boolean praznoPolje(String s) {
        int i = 0;

        for (i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).equals(s)) return false;
        }
        return true;
    }

    public boolean preskaceFigure(String s){
        int i=0;

    //    for (i = 0; i < spisak_figura.size(); i++){


    //    }

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
