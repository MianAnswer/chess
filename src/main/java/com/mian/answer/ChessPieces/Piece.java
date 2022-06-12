package com.mian.answer.ChessPieces;

public abstract class Piece {
    protected ChessPieceIdentifier pieceIdentifier;
    protected ColorIdentifier colorIdentifier;

    public ColorIdentifier getColorIdentifier() {
        return colorIdentifier;
    }

    public ChessPieceIdentifier getPieceIdentifier() {
        return pieceIdentifier;
    }
}
