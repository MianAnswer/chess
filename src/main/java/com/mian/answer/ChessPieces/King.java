package com.mian.answer.ChessPieces;

import com.mian.answer.ChessPieceIdentifier;
import com.mian.answer.ColorIdentifier;

public class King extends Piece {
    public King(ColorIdentifier colorIdentifier) {
        this.colorIdentifier = colorIdentifier;
        this.pieceIdentifier = ChessPieceIdentifier.KING;
    }
}
