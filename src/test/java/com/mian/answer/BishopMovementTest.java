package com.mian.answer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mian.answer.ChessGameEngine.ChessBoard;
import com.mian.answer.ChessGameEngine.PieceMovements;
import com.mian.answer.ChessGameEngine.Position;

public class BishopMovementTest {
    @Test
    public void moveBishopTest() {
        String[][] boardTestCase = {
                { "BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR" },
                { "BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP" },
                { "--", "--", "--", "--", "--", "--", "--", "--" },
                { "--", "--", "--", "--", "--", "--", "--", "--" },
                { "--", "--", "WB", "--", "--", "--", "--", "--" },
                { "--", "--", "--", "--", "--", "--", "--", "--" },
                { "WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP" },
                { "WR", "WN", "WB", "WQ", "WK", "--", "WN", "WR" }
        };
        ChessBoard chessBoard = new ChessBoard(boardTestCase);
        PieceMovements pieceMovements = new PieceMovements();

        boolean test = false;
        test = pieceMovements.bishopMovement(chessBoard, new Position(2, 4), new Position(4, 2));
        assertTrue("Failed BISHOP movement", test);

        test = pieceMovements.bishopMovement(chessBoard, new Position(4, 2), new Position(0, 6));
        assertFalse("Failed BISHOP movement", test);

        test = pieceMovements.bishopMovement(chessBoard, new Position(4, 2), new Position(5, 1));
        assertTrue("Failed BISHOP movement", test);

        test = pieceMovements.bishopMovement(chessBoard, new Position(5, 1), new Position(7, 3));
        assertTrue("Failed BISHOP movement", test);

        test = pieceMovements.bishopMovement(chessBoard, new Position(7, 3), new Position(5, 5));
        assertTrue("Failed BISHOP movement", test);

        test = pieceMovements.bishopMovement(chessBoard, new Position(5, 5), new Position(0, 0));
        assertFalse("Failed BISHOP movement", test);

        test = pieceMovements.bishopMovement(chessBoard, new Position(5, 5), new Position(2, 2));
        assertTrue("Failed BISHOP movement", test);

        test = pieceMovements.bishopMovement(chessBoard, new Position(4, 2), new Position(4, 3));
        assertFalse("Failed BISHOP movement", test);

        test = pieceMovements.bishopMovement(chessBoard, new Position(4, 2), new Position(3, 2));
        assertFalse("Failed BISHOP movement", test);

        System.out.println(chessBoard.displayBoard());
    }
}
