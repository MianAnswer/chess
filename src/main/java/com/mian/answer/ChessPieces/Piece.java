package com.mian.answer.ChessPieces;

import com.mian.answer.ChessPieceIdentifier;
import com.mian.answer.ColorIdentifier;

public abstract class Piece {
    protected ChessPieceIdentifier pieceIdentifier;
    protected ColorIdentifier colorIdentifier;

    public ColorIdentifier getColorIdentifier() {
        return colorIdentifier;
    }

    public ChessPieceIdentifier getPieceIdentifier() {
        return pieceIdentifier;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
