package com.mian.answer.ChessPieces;

import com.mian.answer.ChessPieceIdentifier;
import com.mian.answer.ColorIdentifier;

public class Queen extends Piece {
    public Queen(ColorIdentifier colorIdentifier) {
        this.colorIdentifier = colorIdentifier;
        this.pieceIdentifier = ChessPieceIdentifier.QUEEN;
    }
}
