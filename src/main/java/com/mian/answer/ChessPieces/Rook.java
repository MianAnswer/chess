package com.mian.answer.ChessPieces;

import com.mian.answer.ChessPieceIdentifier;
import com.mian.answer.ColorIdentifier;

public class Rook extends Piece {
    public Rook(ColorIdentifier colorIdentifier) {
        this.colorIdentifier = colorIdentifier;
        this.pieceIdentifier = ChessPieceIdentifier.ROOK;
    }
}
