package com.mian.answer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mian.answer.ChessGameEngine.ChessBoard;
import com.mian.answer.ChessGameEngine.PieceMovements;
import com.mian.answer.ChessGameEngine.Position;

public class PawnMovementTest {
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
