package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopTest {

    @org.junit.jupiter.api.Test
    void moveDiagonal1() {
        Queen k = new Queen("F1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("A6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal12() {
        Queen k = new Queen("C1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("A3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal2() {
        Queen k = new Queen("C1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("H6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal22() {
        Queen k = new Queen("F1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("H3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal3() {
        Queen k = new Queen("F8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("A3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal32() {
        Queen k = new Queen("C8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("A6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal4() {
        Queen k = new Queen("C8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("H3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal42() {
        Queen k = new Queen("F8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("H6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        King k = new King("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        King k = new King("E3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new King("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new King("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new King("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        King k = new King("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        King k = new King("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        King k = new King("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }
}