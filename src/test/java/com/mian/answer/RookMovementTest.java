package com.mian.answer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mian.answer.ChessGameEngine.ChessBoard;
import com.mian.answer.ChessGameEngine.PieceMovements;
import com.mian.answer.ChessGameEngine.Position;

public class RookMovementTest {

    @Test
    public void moveRookTest() {
        String[][] boardTestCase = {
                { "BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR" },
                { "BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP" },
                { "--", "--", "--", "--", "--", "--", "--", "--" },
                { "--", "--", "--", "--", "WR", "--", "--", "WP" },
                { "--", "--", "--", "--", "--", "--", "--", "--" },
                { "--", "--", "--", "--", "--", "--", "--", "--" },
                { "WP", "WP", "WP", "WP", "WP", "WP", "WP", "--" },
                { "WR", "WN", "WB", "WQ", "WK", "WB", "WN", "--" }
        };
        ChessBoard chessBoard = new ChessBoard(boardTestCase);
        PieceMovements pieceMovements = new PieceMovements();
        boolean test;

        test = pieceMovements.rookMovement(chessBoard, new Position(4, 3), new Position(0, 3));
        assertTrue("Couldn't move Rook to " + new Position(0, 3).toString(), test);

        test = pieceMovements.rookMovement(chessBoard, new Position(0, 3), new Position(7, 3));
        assertFalse("Shouldn't move Rook to " + new Position(7, 3).toString(), test);

        test = pieceMovements.rookMovement(chessBoard, new Position(0, 3), new Position(6, 3));
        assertTrue("Couldn't move Rook to " + new Position(6, 3).toString(), test);

        test = pieceMovements.rookMovement(chessBoard, new Position(6, 3), new Position(6, 0));
        assertFalse("Shouldn't move Rook to " + new Position(6, 0).toString(), test);

        test = pieceMovements.rookMovement(chessBoard, new Position(6, 3), new Position(6, 6));
        assertFalse("Shouldn't move Rook to " + new Position(6, 6).toString(), test);

        test = pieceMovements.rookMovement(chessBoard, new Position(6, 3), new Position(6, 1));
        assertTrue("Couldn't move Rook to " + new Position(6, 1).toString(), test);

        test = pieceMovements.rookMovement(chessBoard, new Position(6, 1), new Position(5, 1));
        assertTrue("Couldn't move Rook to " + new Position(5, 1).toString(), test);

        test = pieceMovements.rookMovement(chessBoard, new Position(5, 1), new Position(4, 2));
        assertFalse("Shouldn't move Rook to " + new Position(4, 2).toString(), test);

    }
}
