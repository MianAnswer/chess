package com.mian.answer.ChessPieces;

import com.mian.answer.ChessPieceIdentifier;
import com.mian.answer.ColorIdentifier;

public class Pawn extends Piece {
    public Pawn(ColorIdentifier colorIdentifier) {
        this.colorIdentifier = colorIdentifier;
        this.pieceIdentifier = ChessPieceIdentifier.PAWN;
    }
}
