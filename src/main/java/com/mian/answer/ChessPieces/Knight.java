package com.mian.answer.ChessPieces;

import com.mian.answer.ChessPieceIdentifier;
import com.mian.answer.ColorIdentifier;

public class Knight extends Piece {
    public Knight(ColorIdentifier colorIdentifier) {
        this.colorIdentifier = colorIdentifier;
        this.pieceIdentifier = ChessPieceIdentifier.KNIGHT;
    }
}
