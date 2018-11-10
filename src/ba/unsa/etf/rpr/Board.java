package ba.unsa.etf.rpr;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

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


    public ChessPiece.Color provjeri_boju(String pozicija) {
        int i = 0;
        //ChessPiece.Color boja = WHITE;

        for (i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).getPosition().equals(pozicija))
                return spisak_figura.get(i).getColor();
        }
        return null;
    }

    public boolean vrati_boju(ChessPiece.Color c1, ChessPiece.Color c2) {
        if (c1.equals(c2)) return true;

        return false;
    }

    public boolean praznoPolje(String s) {
        int i = 0;

        for (i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).getPosition().equals(s)) return false;
        }
        return true;
    }

    public boolean preskaceFigure(String pocetnaPozicija, String krajnjaPozicija) {
        int i = 0;

        int pX = pocetnaPozicija.charAt(0) - 'A';
        int pY = pocetnaPozicija.charAt(1) - '1';
        int kX = krajnjaPozicija.charAt(0) - 'A';
        int kY = krajnjaPozicija.charAt(1) - '1';
        int dX = kX - pX;
        int dY = kY - pY;
        int incX = 0, incY = 0;
        if (dX > 0)
            incX = 1;
        else if (dX < 0)
            incX = -1;

        if (dY > 0)
            incY = 1;
        else if (dY < 0)
            incY = -1;

        while (pX != kX-incX && pY != kY-incY) {
            pX += incX;
            pY += incY;
            String temp = "A1";
            char[] t = temp.toCharArray();
            t[0] = (char)('A'+pX);
            t[1] = (char)('1'+pY);
            String trenutnaPozicija = String.valueOf(t);
            if (!praznoPolje(trenutnaPozicija))
                return true;
        }
        return false;
    }

    public int indeksTrazeneFigureUListi(String e) {
        int indeks = 0;
        int i = 0;

        for (i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).getPosition().equals(e)) {
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

        if (boja.equals(ChessPiece.Color.WHITE)) {
            for (int i = 0; i < spisak_figura.size(); i++) {
                if (napadaKralja(spisak_figura.get(i), ChessPiece.Color.BLACK)) {
                    System.out.println("CHECK!!!");
                    return true;
                }
            }
        } else {
            for (int i = 0; i < spisak_figura.size(); i++) {
                if (napadaKralja(spisak_figura.get(i), ChessPiece.Color.WHITE)) {
                    System.out.println("CHECK!!!");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean napadaKralja(ChessPiece chessPiece, ChessPiece.Color boja) {
        String pozicijaKralja = dajPozicijuKralja(boja);
        String trenutnaPozicija = chessPiece.getPosition();
        try {
            chessPiece.move(pozicijaKralja);
            chessPiece.move(trenutnaPozicija);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String dajPozicijuKralja(ChessPiece.Color boja) {
        for (int i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).getClass().equals(King.class) && spisak_figura.get(i).getColor().equals(boja))
                return spisak_figura.get(i).getPosition();
        }
        return null;
    }


    /*void move(Class type, ChessPiece.Color color, String position) pomjera figuru koja pripada klasi type,
    boje color, na poziciju datu stringom position. Ova metoda treba najprije pronaći figuru tipa type date
    boje među aktivnim figurama. Zatim treba pozvati njenu metodu move da provjeri da li je poziv legalan.
    Pošto može biti više figura iste boje i tipa, treba pronaći prvu za koju je potez legalan i povući potez.
    U slučaju da ne postoji niti jedna figura za koju je potez legalan treba baciti IllegalChessMoveException.
    Konačno treba provjeriti da li se na odredišnoj poziciji već nalazi figura. Ako se nalazi figura druge boje,
    ona je "pojedena" i treba je izbaciti, a ako se nalazi figura iste boje treba baciti IllegalChessMoveException.
    Također treba voditi računa da kraljica, lovac, top i pijuni ne mogu preskakati druge figure.*/


    public void move(Class type, ChessPiece.Color color, String e4) {
        int i = 0;
        boolean prosao = false;
        for (i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).getClass().equals(type) && spisak_figura.get(i).getColor().equals(color)) {
                try {
                    move(spisak_figura.get(i).getPosition(), e4);
                    return;
                } catch (Exception e) {
                    throw new IllegalChessMoveException(e.getMessage());
                }
            }
        }
    }

    public void move(String e2, String e) {
        int i = 0;
        int ind1 = 0;
        int ind2 = 0;
        ind1 = indeksTrazeneFigureUListi(e2);
        ind2 = indeksTrazeneFigureUListi(e);

        /*if (!praznoPolje(e)) throw new IllegalArgumentException("Greška!");*/
        if (preskaceFigure(e2, e)) throw new IllegalChessMoveException("Preskače figure");

        if (!praznoPolje(e) && !vrati_boju(provjeri_boju(e2), provjeri_boju(e))) {
            spisak_figura.remove(ind2);// jede se figura koja je bila na starom mjestu
            spisak_figura.get(ind1).move(e); //pomjeramo figuru na novo mjesto
        } else {
            spisak_figura.get(ind1).move(e);
        }

    }


}
