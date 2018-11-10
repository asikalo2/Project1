package ba.unsa.etf.rpr;

import com.sun.org.apache.bcel.internal.generic.D2F;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueenTest {

    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Queen k = new Queen("D1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("H1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal2() {
        Queen k = new Queen("D1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("A1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal3() {
        Queen k = new Queen("D8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("A5")
        );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal4() {
        Queen k = new Queen("D8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("H4")
        );
    }

    @org.junit.jupiter.api.Test
    void moveForward() {
        Queen k = new Queen("D1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("D7")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIlegal() {
        Queen k = new Queen("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("E3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveForward2() {
        Queen k = new Queen("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("E7")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Queen k = new Queen("E6", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Queen k = new Queen("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Queen k = new Queen("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Queen k = new Queen("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }
}