package com.mian.answer;

import com.mian.answer.ChessPieces.Bishop;
import com.mian.answer.ChessPieces.King;
import com.mian.answer.ChessPieces.Knight;
import com.mian.answer.ChessPieces.Pawn;
import com.mian.answer.ChessPieces.Piece;
import com.mian.answer.ChessPieces.Queen;
import com.mian.answer.ChessPieces.Rook;

public class PieceFactory {
    public Piece getPiece(ChessPieceIdentifier chessPieceIdentifier, ColorIdentifier colorIdentifier) {
        switch (chessPieceIdentifier) {
            case KING:
                return new King(colorIdentifier);
            case QUEEN:
                return new Queen(colorIdentifier);
            case PAWN:
                return new Pawn(colorIdentifier);
            case BISHOP:
                return new Bishop(colorIdentifier);
            case ROOK:
                return new Rook(colorIdentifier);
            case KNIGHT:
                return new Knight(colorIdentifier);
        }

        return null;
    }
}
