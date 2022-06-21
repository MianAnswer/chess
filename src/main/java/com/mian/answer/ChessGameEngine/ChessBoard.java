package com.mian.answer.ChessGameEngine;

import com.mian.answer.ChessPieceIdentifier;
import com.mian.answer.ColorIdentifier;
import com.mian.answer.PieceFactory;
import com.mian.answer.ChessPieces.Piece;

public class ChessBoard {

    private Piece[][] board;

    public ChessBoard() {
        this.board = new Piece[8][8];
        setBoard();
    }

    private void setBoard() {
        PieceFactory pieceFactory = new PieceFactory();

        // set the black pieces
        this.board[0][0] = pieceFactory.getPiece(ChessPieceIdentifier.ROOK, ColorIdentifier.BLACK);
        this.board[0][1] = pieceFactory.getPiece(ChessPieceIdentifier.KNIGHT, ColorIdentifier.BLACK);
        this.board[0][2] = pieceFactory.getPiece(ChessPieceIdentifier.BISHOP, ColorIdentifier.BLACK);
        this.board[0][3] = pieceFactory.getPiece(ChessPieceIdentifier.QUEEN, ColorIdentifier.BLACK);
        this.board[0][4] = pieceFactory.getPiece(ChessPieceIdentifier.KING, ColorIdentifier.BLACK);
        this.board[0][5] = pieceFactory.getPiece(ChessPieceIdentifier.BISHOP, ColorIdentifier.BLACK);
        this.board[0][6] = pieceFactory.getPiece(ChessPieceIdentifier.KNIGHT, ColorIdentifier.BLACK);
        this.board[0][7] = pieceFactory.getPiece(ChessPieceIdentifier.ROOK, ColorIdentifier.BLACK);

        for (int file = 0; file < this.board[1].length; ++file) {
            this.board[1][file] = pieceFactory.getPiece(ChessPieceIdentifier.PAWN, ColorIdentifier.BLACK);
        }

        // set the white pieces
        this.board[7][0] = pieceFactory.getPiece(ChessPieceIdentifier.ROOK, ColorIdentifier.WHITE);
        this.board[7][1] = pieceFactory.getPiece(ChessPieceIdentifier.KNIGHT, ColorIdentifier.WHITE);
        this.board[7][2] = pieceFactory.getPiece(ChessPieceIdentifier.BISHOP, ColorIdentifier.WHITE);
        this.board[7][3] = pieceFactory.getPiece(ChessPieceIdentifier.QUEEN, ColorIdentifier.WHITE);
        this.board[7][4] = pieceFactory.getPiece(ChessPieceIdentifier.KING, ColorIdentifier.WHITE);
        this.board[7][5] = pieceFactory.getPiece(ChessPieceIdentifier.BISHOP, ColorIdentifier.WHITE);
        this.board[7][6] = pieceFactory.getPiece(ChessPieceIdentifier.KNIGHT, ColorIdentifier.WHITE);
        this.board[7][7] = pieceFactory.getPiece(ChessPieceIdentifier.ROOK, ColorIdentifier.WHITE);

        for (int file = 0; file < this.board[6].length; ++file) {
            this.board[6][file] = pieceFactory.getPiece(ChessPieceIdentifier.PAWN, ColorIdentifier.WHITE);
        }
    }

    public Piece[][] getBoard() {
        return this.board;
    }

    public String displayBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rank = 0; rank < this.board.length; ++rank) {
            for (int file = 0; file < this.board[rank].length; ++file) {
                Piece piece = this.board[rank][file];
                if (piece != null) {
                    sb.append(piece.getName().charAt(0));
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
