package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RookTest {

    @org.junit.jupiter.api.Test
    void moveRight() {
        Rook r = new Rook("D1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("H1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveLeft() {
        Rook r = new Rook("H1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("A1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIlegal() {
        Rook r = new Rook("D1", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> r.move("A4")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIlegal2() {
        Rook r = new Rook("D1", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> r.move("H5")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIlegal3() {
        Rook r = new Rook("D8", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> r.move("A5")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIlegal4() {
        Rook r = new Rook("D8", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("H4")
        );
    }

    @org.junit.jupiter.api.Test
    void moveForward() {
        Rook r = new Rook("D1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("D7")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIlegal5() {
        Rook r = new Rook("C2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> r.move("E3")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Rook r = new Rook("E6", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("E2")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Rook r = new Rook("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> r.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Rook r = new Rook("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> r.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Rook r = new Rook("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> r.move("")
        );
    }
}
