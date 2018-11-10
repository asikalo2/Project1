package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void move() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C3")
        );
    }
    @Test
    void moveRight() {
        Knight k = new Knight("D1", ChessPiece.Color.WHITE);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("H1")
        );
    }
    @Test
    void moveForward() {
            Knight k = new Knight("A1", ChessPiece.Color.WHITE);
            assertThrows(
                    IllegalArgumentException.class,
                    () -> k.move("A3")
        );
    }

    @Test
    void moveLeft() {
        Knight k = new Knight("H1", ChessPiece.Color.WHITE);
        assertThrows(
                    IllegalArgumentException.class,
                    () -> k.move("D1")
            );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonal12() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
            assertThrows(
                    IllegalArgumentException.class,
                    () -> k.move("H5")
            );
    }

    @org.junit.jupiter.api.Test
    void moveDiagonall() {
        Knight k = new Knight("B8", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                    () -> k.move("A5")
            );
    }

    @org.junit.jupiter.api.Test
    void move2() {
        Knight k = new Knight("G8", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> k.move("H6")
        );
    }

    @org.junit.jupiter.api.Test
    void move3() {
            Knight k = new Knight("G8", ChessPiece.Color.BLACK);
            assertDoesNotThrow(
                    () -> k.move("F6")
            );
        }


    @org.junit.jupiter.api.Test
    void legal() {
        Knight k = new Knight("C2", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                    () -> k.move("E3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveForward2() {
        Knight k = new Knight("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("E7")
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
        Knight k = new Knight("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Knight k = new Knight("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Knight k = new Knight("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }
}
