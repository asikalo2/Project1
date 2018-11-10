package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        int i=0;
        String figura = "";
        String polje = "";
        String figura2 = "";
        String polje2 = "";


        /*Klasa Program sadrži metodu main koja omogućuje igračima da povlače poteze.
        Korisnik unosi naizmjenično poteze bijelog i crnog igrača koristeći skraćenu (algebarsku) notaciju uz
        oznake figura na engleskom jeziku: K, Q, R, B i N, dok se polja označavaju malim slovom.
        U metodi main treba biti kreiran objekat tipa Board te koristiti prvu varijantu metode move za povlačenje poteza.
        U slučaju neispravnog poteza ispisati poruku "Illegal move" i tražiti ponovni unos. U slučaju da je nakon nekog
        poteza došlo do šaha treba ispisati poruku "CHECK!!!" što se saznaje pomoću metode isCheck.
        Korisnik može unijeti slovo X da preda partiju. Primjer ulaza i izlaza:*/

        System.out.println("Početak igre! Dobrodošli! :)");
            Board b = new Board();
            do{
            System.out.print("White move: ");
                do {
                    Scanner ulaz = new Scanner(System.in);
                    ulaz.nextLine();
                    figura = ulaz.nextLine();
                    if((figura.charAt(0) < 'A' || figura.charAt(0) > 'Z' || figura.length() > 1))
                        System.out.println("Illegal move!");
                } while ((figura.charAt(0) < 'A' || figura.charAt(0) >'Z' || figura.length()>1));
                do {
                    Scanner ulaz = new Scanner(System.in);
                        ulaz.nextLine();
                        polje = ulaz.nextLine();
                    if((polje.charAt(0) < 'a' || polje.charAt(0) > 'z' || polje.charAt(1) < '1' ||
                            polje.charAt(1) > '8'  ))
                        System.out.println("Illegal move!");
                } while ((polje.charAt(0) < 'a' || polje.charAt(0) > 'z' || polje.charAt(1) < '1' ||
                        polje.charAt(1) > '8'  ));

                if(figura.equals('K')) b.move(King.class, ChessPiece.Color.WHITE, polje);
                else if (figura.equals('Q')) b.move(Queen.class, ChessPiece.Color.WHITE, polje);
                else if (figura.equals('R')) b.move(Rook.class, ChessPiece.Color.WHITE, polje);
                else if (figura.equals('B')) b.move(Bishop.class, ChessPiece.Color.WHITE, polje);
                else if (figura.equals('N')) b.move(Knight.class, ChessPiece.Color.WHITE, polje);
                else b.move(Pawn.class, ChessPiece.Color.WHITE, polje);

                System.out.println("\n");

                System.out.print("Black move: ");

                    do {
                        Scanner ulaz = new Scanner(System.in);
                        ulaz.nextLine();
                        figura2 = ulaz.nextLine();
                        if((figura2.charAt(0) < 'A' || figura2.charAt(0) > 'Z' || figura2.length() > 1))
                            System.out.println("Illegal move!");
                    }    while ((figura2.charAt(0) < 'A' || figura2.charAt(0) > 'Z' || figura2.length() > 1)) ;
                    do {
                        Scanner ulaz = new Scanner(System.in);
                            ulaz.nextLine();
                            polje2 = ulaz.nextLine();
                            if((polje2.charAt(0) < 'a' || polje2.charAt(0) > 'z' || polje2.charAt(1) < '1' ||
                                  polje2.charAt(1) > '8'  ))
                            System.out.println("Illegal move!");
                    } while ((polje2.charAt(0) < 'a' || polje2.charAt(0) > 'z' || polje2.charAt(1) < '1' ||
                            polje2.charAt(1) > '8'  ));

                if(figura2.equals('K')) b.move(King.class, ChessPiece.Color.BLACK, polje2);
                else if (figura2.equals('Q')) b.move(Queen.class, ChessPiece.Color.BLACK, polje2);
                else if (figura2.equals('R')) b.move(Rook.class, ChessPiece.Color.BLACK, polje2);
                else if (figura2.equals('B')) b.move(Bishop.class, ChessPiece.Color.BLACK, polje2);
                else if (figura2.equals('N')) b.move(Knight.class, ChessPiece.Color.BLACK, polje2);
                else b.move(Pawn.class, ChessPiece.Color.BLACK, polje2);


            }while(figura.equals('X') || b.getSpisak_figura().size() == 1);
    }
}

