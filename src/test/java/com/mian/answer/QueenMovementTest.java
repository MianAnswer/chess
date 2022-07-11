package com.mian.answer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mian.answer.ChessGameEngine.ChessBoard;
import com.mian.answer.ChessGameEngine.PieceMovements;
import com.mian.answer.ChessGameEngine.Position;

public class QueenMovementTest {
    @Test
    public void moveQueenTest() {
        String[][] boardTestCase = {
                { "BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR" },
                { "BP", "BP", "BP", "--", "BP", "BP", "--", "BP" },
                { "--", "--", "--", "--", "--", "--", "BP", "--" },
                { "--", "WP", "--", "BP", "--", "--", "--", "--" },
                { "--", "--", "--", "--", "WQ", "--", "WP", "WP" },
                { "--", "--", "--", "WP", "--", "--", "--", "--" },
                { "WP", "--", "WP", "--", "WP", "WP", "--", "--" },
                { "WR", "WN", "WB", "--", "WK", "WB", "WN", "WR" }
        };
        Position[] positions = {
                new Position(4, 4),
                new Position(6, 2),
                new Position(4, 0),
                new Position(3, 2),
                new Position(1, 4),
                new Position(3, 3),
                new Position(1, 6),
                new Position(3, 4),
                new Position(3, 3),
                new Position(4, 4),
                new Position(6, 6),
                new Position(7, 6),
                new Position(4, 3),
                new Position(0, 7)
        };
        boolean[] results = {
                true,
                true,
                false,
                true,
                true,
                false,
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

            boolean test = pieceMovements.queenMovement(chessBoard, prevPosition, position);
            assertTrue("Queen Test failed - moving from " + prevPosition.toString() + " to " + position.toString(),
                    test == results[i]);
            if (test == true) {
                prevPosition = position;
            }
        }
    }
}
