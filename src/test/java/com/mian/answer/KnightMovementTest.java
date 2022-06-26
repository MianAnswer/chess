package com.mian.answer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mian.answer.ChessGameEngine.ChessBoard;
import com.mian.answer.ChessGameEngine.PieceMovements;
import com.mian.answer.ChessGameEngine.Position;

public class KnightMovementTest {

    @Test
    public void moveKnightTest() {
        String[][] boardTestCase = {
                { "BR", "--", "BB", "BQ", "BK", "BB", "BN", "BR" },
                { "BP", "BP", "--", "BP", "BP", "BP", "BP", "BP" },
                { "--", "--", "BP", "--", "--", "--", "--", "--" },
                { "--", "--", "--", "--", "--", "--", "--", "--" },
                { "--", "--", "--", "BN", "--", "--", "--", "--" },
                { "--", "--", "--", "WP", "--", "--", "--", "--" },
                { "WP", "WP", "WP", "--", "WP", "WP", "WP", "WP" },
                { "WR", "WN", "WB", "WQ", "WK", "WB", "WN", "WR" }
        };
        ChessBoard chessBoard = new ChessBoard(boardTestCase);
        PieceMovements pieceMovements = new PieceMovements();

        pieceMovements.knightMovement(chessBoard, new Position(3, 4), new Position(2, 2));
        String result = "R-BQKBKR\n" +
                "PP-PPPPP\n" +
                "--P-----\n" +
                "--------\n" +
                "---K----\n" +
                "---P----\n" +
                "PPP-PPPP\n" +
                "RKBQKBKR\n";

        assertTrue("Failed KNIGHT movement", result.equals(chessBoard.displayBoard()));

        pieceMovements.knightMovement(chessBoard, new Position(2, 2), new Position(3, 4));
        pieceMovements.knightMovement(chessBoard, new Position(3, 4), new Position(5, 5));
        result = "R-BQKBKR\n" +
                "PP-PPPPP\n" +
                "--P-----\n" +
                "--------\n" +
                "--------\n" +
                "---P-K--\n" +
                "PPP-PPPP\n" +
                "RKBQKBKR\n";

        assertTrue("Failed KNIGHT movement", result.equals(chessBoard.displayBoard()));

        pieceMovements.knightMovement(chessBoard, new Position(5, 5), new Position(3, 4));
        pieceMovements.knightMovement(chessBoard, new Position(3, 4), new Position(1, 5));
        result = "R-BQKBKR\n" +
                "PP-PPPPP\n" +
                "--P-----\n" +
                "--------\n" +
                "--------\n" +
                "-K-P----\n" +
                "PPP-PPPP\n" +
                "RKBQKBKR\n";

        assertTrue("Failed KNIGHT movement", result.equals(chessBoard.displayBoard()));

        pieceMovements.knightMovement(chessBoard, new Position(1, 5), new Position(3, 4));
        pieceMovements.knightMovement(chessBoard, new Position(3, 4), new Position(5, 3));
        result = "R-BQKBKR\n" +
                "PP-PPPPP\n" +
                "--P-----\n" +
                "-----K--\n" +
                "--------\n" +
                "---P----\n" +
                "PPP-PPPP\n" +
                "RKBQKBKR\n";

        assertTrue("Failed KNIGHT movement", result.equals(chessBoard.displayBoard()));

        pieceMovements.knightMovement(chessBoard, new Position(5, 3), new Position(3, 4));
        pieceMovements.knightMovement(chessBoard, new Position(3, 4), new Position(1, 3));
        result = "R-BQKBKR\n" +
                "PP-PPPPP\n" +
                "--P-----\n" +
                "-K------\n" +
                "--------\n" +
                "---P----\n" +
                "PPP-PPPP\n" +
                "RKBQKBKR\n";

        assertTrue("Failed KNIGHT movement", result.equals(chessBoard.displayBoard()));

        pieceMovements.knightMovement(chessBoard, new Position(1, 3), new Position(3, 4));
        pieceMovements.knightMovement(chessBoard, new Position(3, 4), new Position(4, 6));
        result = "R-BQKBKR\n" +
                "PP-PPPPP\n" +
                "--P-----\n" +
                "--------\n" +
                "--------\n" +
                "---P----\n" +
                "PPP-KPPP\n" +
                "RKBQKBKR\n";

        assertTrue("Failed KNIGHT movement", result.equals(chessBoard.displayBoard()));

        pieceMovements.knightMovement(chessBoard, new Position(4, 6), new Position(3, 4));
        pieceMovements.knightMovement(chessBoard, new Position(3, 4), new Position(2, 6));
        result = "R-BQKBKR\n" +
                "PP-PPPPP\n" +
                "--P-----\n" +
                "--------\n" +
                "--------\n" +
                "---P----\n" +
                "PPK--PPP\n" +
                "RKBQKBKR\n";

        assertTrue("Failed KNIGHT movement", result.equals(chessBoard.displayBoard()));

        pieceMovements.knightMovement(chessBoard, new Position(2, 6), new Position(3, 4));
        pieceMovements.knightMovement(chessBoard, new Position(3, 4), new Position(4, 2));
        result = "R-BQKBKR\n" +
                "PP-PPPPP\n" +
                "--P-K---\n" +
                "--------\n" +
                "--------\n" +
                "---P----\n" +
                "PP---PPP\n" +
                "RKBQKBKR\n";

        assertTrue("Failed KNIGHT movement", result.equals(chessBoard.displayBoard()));

    }

}
