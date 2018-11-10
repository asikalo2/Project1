package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopTest {

    @org.junit.jupiter.api.Test
    void moveDiagonal1() {
        Bishop b = new Bishop("F1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("A6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal12() {
        Bishop b = new Bishop("C1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("A3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal2() {
        Bishop b = new Bishop("C1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("H6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal22() {
        Bishop b = new Bishop("F1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("H3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal3() {
        Bishop b = new Bishop("F8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("A3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal32() {
        Bishop b = new Bishop("C8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("A6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal4() {
        Bishop b = new Bishop("C8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("H3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal42() {
        Bishop b = new Bishop("F8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("H6")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Bishop b = new Bishop("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> b.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Bishop b = new Bishop("E3", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> b.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("I2", ChessPiece.Color.WHITE)
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
                () -> new Bishop("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Bishop b = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Bishop b = new Bishop("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Bishop b = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("")
        );
    }
}