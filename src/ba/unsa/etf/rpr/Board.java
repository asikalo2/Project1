package ba.unsa.etf.rpr;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class Board {

    private List<ChessPiece> spisak_figura = new ArrayList<ChessPiece>(); //lista svih figura

    public Board() {
        //postavljanje figura u početnu poziciju;
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
        //Vraćamo boju figure koja se nalazi na poziciji 'pozicija', tako što prolazimo kroz sve figure, te ukoliko je
        //pozicija neke figure u spisku figura jednaka datoj poziciji, vraćamo boju te figure.
        int i = 0;

        for (i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).getPosition().equals(pozicija))
                return spisak_figura.get(i).getColor();
        }
        return null;
    }

    public boolean vrati_boju(ChessPiece.Color c1, ChessPiece.Color c2) {
        //Provjerava se da li su jednake boje c1 i c2, te se vraća true ako je tačno i false ako je netačno.
        if (c1.equals(c2)) return true;

        return false;
    }

    public boolean praznoPolje(String s) {
        //Provjerava se da li je polje, koje se nalazi na poziciji 's' prazno ili je zauzeto, tako što se prolazi
        //kroz spisak figura, te ukoliko neka figura već sadrži datu poziciju, vraća se false.
        int i = 0;

        for (i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).getPosition().equals(s)) return false;
        }

        return true;
    }

    public boolean preskaceFigure(String pocetnaPozicija, String krajnjaPozicija) {
        //Provjerava se da li se preskaču figure koje se kreću od početne, ka krajnoj poziciji.
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
        //Funkcija vraća indeks tražene figure u listi, tako što se šalje pozicija figure, prolazi se kroz
        //listu figura i vraća indeks ukoliko je pronađena figura s datom pozicijom.
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
        // Vraća se spisak figura.

        return spisak_figura;
    }

    public boolean isCheck(ChessPiece.Color color) {
        //Funkcija isCheck provjerava da li je igrač, tj. figura King igrača koji je boja 'color' u šahu.

        if (color.equals(ChessPiece.Color.WHITE)) {
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

    private String dajPozicijuKralja(ChessPiece.Color color) {
        //Funkcija vraća poziciju kralja boje 'color'.
        for (int i = 0; i < spisak_figura.size(); i++) {
            if (spisak_figura.get(i).getClass().equals(King.class) && spisak_figura.get(i).getColor().equals(color))
                return spisak_figura.get(i).getPosition();
        }
        return null;
    }

    public void move(Class type, ChessPiece.Color color, String e4) {

        /*Funkcija move pomjera figuru koja pripada klasi type, boje color, na poziciju datu stringom e4.
        Ova metoda treba pronalazi figuru tipa type date boje među aktivnim figurama.
        Pošto može biti više figura iste boje i tipa, pronalazi se pomoću bacanja izuzetka, prva za koju je potez
        legalan. U slučaju da ne postoji niti jedna figura za koju je potez legalan baca se IllegalChessMoveException.

        Provjerava se da li se na odredišnoj poziciji već nalazi figura, ako se nalazi figura druge boje,
        ona je "pojedena" i izbacuje se iz liste, a ako se nalazi figura iste boje baca se IllegalChessMoveException.
        Također, vodi se računa da kraljica, lovac, top i pijuni ne mogu preskakati druge figure.

        U ovoj metodi, obzirom da sam prvo pisala metodu move koje se preklapa sa ovom, pozivam tu metodu, u kojoj je
        implementirano detaljno pozivanje, te izvšene sve provjere. Nisam pisala ponovo, zbog nepotrebnog ponavljanja
        koda.*/

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
        //Metoda move vrši sve provjere kao i prva metoda move, samo što u ovom slučaju pomjera se figura sa pozicije
        //e2 na poziciju e.
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
        } else if(praznoPolje(e)) {
            spisak_figura.get(ind1).move(e);
        }
        else{
            throw new IllegalChessMoveException("Preskače figure");
        }

    }


}
