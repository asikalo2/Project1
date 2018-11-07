package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<ChessPiece> spisak_figura = new ArrayList<ChessPiece>();

    public boolean daLiJeZauzetoPolje(String e){
        int i=0;

        for (i=0; i < spisak_figura.size();  i++){
            if(spisak_figura.get(i).equals(e)) return true;
        }
        return false;
    }

    public List<ChessPiece> getSpisak_figura() {
        return spisak_figura;
    }

    public void setSpisak_figura(List<ChessPiece> spisak_figura) {
        this.spisak_figura = spisak_figura;
    }

    public boolean isCheck(ChessPiece.Color white) {
        return false;
    }


    public void move(Class Chesspiece, ChessPiece.Color white, String e4) {

    }


    public void move(String e2, String e4) {
     //   if(!daLiJeZauzetoPolje(e4)){
            //ChessPiece.setPosition()
    //    }
    }


}
