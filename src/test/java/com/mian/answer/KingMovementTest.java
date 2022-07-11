package com.mian.answer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mian.answer.ChessGameEngine.ChessBoard;
import com.mian.answer.ChessGameEngine.PieceMovements;
import com.mian.answer.ChessGameEngine.Position;

public class KingMovementTest {
    @Test
    public void moveKingTest() {
        String[][] boardTestCase = {
                { "BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR" },
                { "BP", "BP", "BP", "BP", "--", "BP", "BP", "BP" },
                { "--", "--", "--", "--", "BP", "--", "--", "--" },
                { "--", "--", "--", "--", "--", "--", "--", "--" },
                { "--", "--", "--", "--", "WK", "--", "--", "--" },
                { "--", "--", "--", "--", "WP", "--", "--", "--" },
                { "WP", "WP", "WP", "WP", "--", "WP", "WP", "WP" },
                { "WR", "WN", "WB", "WQ", "--", "WB", "WN", "WR" }
        };
        Position[] positions = {
                new Position(4, 4),
                new Position(4, 3),
                new Position(4, 4),
                new Position(5, 4),
                new Position(4, 4),
                new Position(5, 3),
                new Position(4, 2),
                new Position(5, 3),
                new Position(4, 4),
                new Position(4, 5),
        };
        boolean[] results = {
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                false
        };
        ChessBoard chessBoard = new ChessBoard(boardTestCase);
        PieceMovements pieceMovements = new PieceMovements();
        Position prevPosition = positions[0];
        for (int i = 1; i < positions.length; ++i) {
            Position position = positions[i];

            boolean test = pieceMovements.kingMovement(chessBoard, prevPosition, position);
            assertTrue("King Test failed - moving from " + prevPosition.toString() + " to " + position.toString(),
                    test == results[i]);
            if (test == true) {
                prevPosition = position;
            }
        }
    }
}
