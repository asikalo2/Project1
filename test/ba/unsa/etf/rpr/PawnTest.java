package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }

    @org.junit.jupiter.api.Test
    void moveRight() {
        Pawn p = new Pawn("D2", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("H2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveLeft() {
        Pawn p = new Pawn("H2", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("A2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal1() {
        Pawn p = new Pawn("D2", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("A5")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal12() {
        Pawn p = new Pawn("D2", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("H6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal3() {
        Pawn p = new Pawn("D8", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("A5")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal32() {
        Pawn p = new Pawn("D8", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("H4")
        );
    }

    @org.junit.jupiter.api.Test
    void moveForward() {
        Pawn p = new Pawn("D2", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("D7")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIlegal() {
        Pawn p = new Pawn("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("E3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveForward2() {
        Pawn p = new Pawn("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("E7")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Pawn p = new Pawn("E6", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Pawn p = new Pawn("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> p.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Pawn p = new Pawn("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> p.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Pawn p = new Pawn("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> p.move("")
        );
    }

}