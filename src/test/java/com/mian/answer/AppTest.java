package com.mian.answer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mian.answer.ChessPieces.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    PieceFactory pieceFactory = new PieceFactory();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void bishopTest()
    {
        Piece piece = pieceFactory.getPiece(ChessPieceIdentifier.BISHOP, ColorIdentifier.BLACK);
        assertTrue(piece.getPieceIdentifier() == ChessPieceIdentifier.BISHOP);
        assertTrue(piece.getColorIdentifier() == ColorIdentifier.BLACK);
    }
    
    @Test
    public void pawnTest() {
        Piece piece = pieceFactory.getPiece(ChessPieceIdentifier.PAWN, ColorIdentifier.BLACK);
        assertTrue(piece.getPieceIdentifier() == ChessPieceIdentifier.PAWN);
        assertTrue(piece.getColorIdentifier() == ColorIdentifier.BLACK);
    }

    @Test
    public void queenTest() {
        Piece piece = pieceFactory.getPiece(ChessPieceIdentifier.QUEEN, ColorIdentifier.BLACK);
        assertTrue(piece.getPieceIdentifier() == ChessPieceIdentifier.QUEEN);
        assertTrue(piece.getColorIdentifier() == ColorIdentifier.BLACK);
    }

    @Test
    public void kingTest() {
        Piece piece = pieceFactory.getPiece(ChessPieceIdentifier.KING, ColorIdentifier.BLACK);
        assertTrue(piece.getPieceIdentifier() == ChessPieceIdentifier.KING);
        assertTrue(piece.getColorIdentifier() == ColorIdentifier.BLACK);
    }

    @Test
    public void knightTest() {
        Piece piece = pieceFactory.getPiece(ChessPieceIdentifier.KNIGHT, ColorIdentifier.BLACK);
        assertTrue(piece.getPieceIdentifier() == ChessPieceIdentifier.KNIGHT);
        assertTrue(piece.getColorIdentifier() == ColorIdentifier.BLACK);
    }

    @Test
    public void rookTest() {
        Piece piece = pieceFactory.getPiece(ChessPieceIdentifier.ROOK, ColorIdentifier.BLACK);
        assertTrue(piece.getPieceIdentifier() == ChessPieceIdentifier.ROOK);
        assertTrue(piece.getColorIdentifier() == ColorIdentifier.BLACK);
    }
}
