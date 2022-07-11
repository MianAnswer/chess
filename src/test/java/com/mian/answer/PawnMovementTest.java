package com.mian.answer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mian.answer.ChessGameEngine.ChessBoard;
import com.mian.answer.ChessGameEngine.PieceMovements;
import com.mian.answer.ChessGameEngine.Position;

public class PawnMovementTest {
    @Test
    public void movePawnTest() {
        ChessBoard chessBoard = new ChessBoard();
        PieceMovements pieceMovements = new PieceMovements();
        Object[][][] arrTesting = {
                {
                        { new Position(0, 1), true },
                        { new Position(0, 2), true },
                        { new Position(0, 3), true },
                        { new Position(0, 2), false },
                        { new Position(1, 4), false },
                        { new Position(0, 5), false }
                },
                {
                        { new Position(2, 6), true },
                        { new Position(2, 4), true },
                        { new Position(1, 3), false },
                        { new Position(3, 3), false },
                        { new Position(2, 3), true }
                },
                {
                        { new Position(2, 1), true },
                        { new Position(2, 3), false }
                },
                {
                        { new Position(3, 6), true },
                        { new Position(3, 7), false },
                        { new Position(2, 7), false },
                        { new Position(4, 7), false },
                        { new Position(3, 4), true },
                        { new Position(2, 5), false },
                        { new Position(2, 4), false },
                        { new Position(4, 4), false },
                        { new Position(4, 5), false }
                },
                {
                        { new Position(4, 6), true },
                        { new Position(4, 4), true },
                        { new Position(4, 5), false }
                },
                {
                        { new Position(4, 1), true },
                        { new Position(4, 3), true }
                },
                {
                        { new Position(6, 6), true },
                        { new Position(6, 4), true }
                },
                {
                        { new Position(6, 1), true },
                        { new Position(6, 2), true }
                },
                {
                        { new Position(5, 1), true },
                        { new Position(5, 3), true }
                },
                {
                        { new Position(4, 3), true },
                        { new Position(5, 3), false }
                },
                {
                        { new Position(6, 4), true },
                        { new Position(6, 2), false },
                        { new Position(5, 3), true }
                },
                {
                        { new Position(6, 2), true },
                        { new Position(5, 3), true }
                },
                {
                        { new Position(4, 4), true },
                        { new Position(5, 3), true }
                },
                {
                        { new Position(7, 6), true },
                        { new Position(7, 3), false }
                }
        };

        for (int j = 0; j < arrTesting.length; ++j) {
            Object[][] positions = arrTesting[j];
            Position prevPosition = (Position) positions[0][0];
            for (int i = 1; i < positions.length; ++i) {
                Position position = (Position) positions[i][0];

                boolean test = pieceMovements.pawnMovement(chessBoard, prevPosition, position);
                assertTrue("King Test failed - moving from " + prevPosition.toString() + " to " + position.toString(),
                        test == (Boolean) positions[i][1]);
                if (test == true) {
                    prevPosition = position;
                }
            }
        }

    }

    @Test
    public void movingForward1StepTest() {
        ChessBoard chessBoard = new ChessBoard();
        PieceMovements pieceMovements = new PieceMovements();
        pieceMovements.pawnMovement(chessBoard, new Position(0, 6), new Position(0, 5));
        pieceMovements.pawnMovement(chessBoard, new Position(1, 6), new Position(1, 5));
        pieceMovements.pawnMovement(chessBoard, new Position(2, 6), new Position(2, 5));
        pieceMovements.pawnMovement(chessBoard, new Position(3, 6), new Position(3, 5));
        pieceMovements.pawnMovement(chessBoard, new Position(4, 6), new Position(4, 5));
        pieceMovements.pawnMovement(chessBoard, new Position(5, 6), new Position(5, 5));
        pieceMovements.pawnMovement(chessBoard, new Position(6, 6), new Position(6, 5));
        pieceMovements.pawnMovement(chessBoard, new Position(7, 6), new Position(7, 5));

        String result = "RKBQKBKR\n" +
                "PPPPPPPP\n" +
                "--------\n" +
                "--------\n" +
                "--------\n" +
                "PPPPPPPP\n" +
                "--------\n" +
                "RKBQKBKR\n";
        assertTrue("Failed pawn movement", result.equals(chessBoard.displayBoard()));
    }

    @Test
    public void movingForward2StepsTest() {
        ChessBoard chessBoard = new ChessBoard();
        PieceMovements pieceMovements = new PieceMovements();
        pieceMovements.pawnMovement(chessBoard, new Position(0, 6), new Position(0, 4));
        pieceMovements.pawnMovement(chessBoard, new Position(1, 6), new Position(1, 4));
        pieceMovements.pawnMovement(chessBoard, new Position(2, 6), new Position(2, 4));
        pieceMovements.pawnMovement(chessBoard, new Position(3, 6), new Position(3, 4));
        pieceMovements.pawnMovement(chessBoard, new Position(4, 6), new Position(4, 4));
        pieceMovements.pawnMovement(chessBoard, new Position(5, 6), new Position(5, 4));
        pieceMovements.pawnMovement(chessBoard, new Position(6, 6), new Position(6, 4));
        pieceMovements.pawnMovement(chessBoard, new Position(7, 6), new Position(7, 4));

        String result = "RKBQKBKR\n" +
                "PPPPPPPP\n" +
                "--------\n" +
                "--------\n" +
                "PPPPPPPP\n" +
                "--------\n" +
                "--------\n" +
                "RKBQKBKR\n";
        assertTrue("Failed pawn movement", result.equals(chessBoard.displayBoard()));
    }

    @Test
    public void movingDiagonallyStepsTest() {
        ChessBoard chessBoard = new ChessBoard();
        PieceMovements pieceMovements = new PieceMovements();
        chessBoard.movePiece(new Position(6, 0), new Position(1, 5));
        chessBoard.movePiece(new Position(1, 0), new Position(6, 5));

        pieceMovements.pawnMovement(chessBoard, new Position(0, 6), new Position(1, 5));
        pieceMovements.pawnMovement(chessBoard, new Position(7, 6), new Position(6, 5));

        String result = "R-BQKB-R\n" +
                "PPPPPPPP\n" +
                "--------\n" +
                "--------\n" +
                "--------\n" +
                "-P----P-\n" +
                "-PPPPPP-\n" +
                "RKBQKBKR\n";
        assertTrue("Failed pawn movement", result.equals(chessBoard.displayBoard()));
    }
}
