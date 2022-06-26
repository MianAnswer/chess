package com.mian.answer.ChessGameEngine;

import com.mian.answer.ChessPieceIdentifier;
import com.mian.answer.ColorIdentifier;
import com.mian.answer.PieceFactory;
import com.mian.answer.ChessPieces.Piece;

public class ChessBoard {

    private Piece[][] board;
    private String[][] strBoardSetUp = {
            { "BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR" },
            { "BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP" },
            { "--", "--", "--", "--", "--", "--", "--", "--" },
            { "--", "--", "--", "--", "--", "--", "--", "--" },
            { "--", "--", "--", "--", "--", "--", "--", "--" },
            { "--", "--", "--", "--", "--", "--", "--", "--" },
            { "WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP" },
            { "WR", "WN", "WB", "WQ", "WK", "WB", "WN", "WR" }
    };

    public ChessBoard() {
        this.board = new Piece[ChessBoardConstants.MAX_FILE][ChessBoardConstants.MAX_RANK];
        setBoard(strBoardSetUp);
    }

    public ChessBoard(String[][] strBoard) {
        this.board = new Piece[ChessBoardConstants.MAX_FILE][ChessBoardConstants.MAX_RANK];
        if (strBoard == null || strBoard.length != ChessBoardConstants.MAX_FILE
                || strBoard[0].length != ChessBoardConstants.MAX_RANK) {
            setBoard(strBoardSetUp);
        } else {
            setBoard(strBoard);
        }
    }

    private void setBoard(String[][] strBoard) {
        PieceFactory pieceFactory = new PieceFactory();
        for (int file = 0; file < ChessBoardConstants.MAX_FILE; ++file) {
            for (int rank = 0; rank < ChessBoardConstants.MAX_RANK; ++rank) {
                char color = strBoard[file][rank].charAt(0);
                char name = strBoard[file][rank].charAt(1);

                Piece piece = null;

                ColorIdentifier colorIdentifier = (color == 'B') ? ColorIdentifier.BLACK : ColorIdentifier.WHITE;
                switch (name) {
                    case 'P':
                        piece = pieceFactory.getPiece(ChessPieceIdentifier.PAWN, colorIdentifier);
                        break;
                    case 'R':
                        piece = pieceFactory.getPiece(ChessPieceIdentifier.ROOK, colorIdentifier);
                        break;
                    case 'N':
                        piece = pieceFactory.getPiece(ChessPieceIdentifier.KNIGHT, colorIdentifier);
                        break;
                    case 'B':
                        piece = pieceFactory.getPiece(ChessPieceIdentifier.BISHOP, colorIdentifier);
                        break;
                    case 'Q':
                        piece = pieceFactory.getPiece(ChessPieceIdentifier.QUEEN, colorIdentifier);
                        break;
                    case 'K':
                        piece = pieceFactory.getPiece(ChessPieceIdentifier.KING, colorIdentifier);
                        break;
                }

                this.board[file][rank] = piece;
            }
        }
    }

    public boolean isValidPosition(Position position) {
        int rank = position.getRank();
        int file = position.getFile();
        return rank >= 0 || file >= 0 || rank < ChessBoardConstants.MAX_RANK || file < ChessBoardConstants.MAX_FILE;
    }

    public Piece getPiece(Position position) {
        return isValidPosition(position) ? this.board[position.getFile()][position.getRank()] : null;
    }

    public void placePiece(Piece piece, Position position) {
        if (isValidPosition(position)) {
            this.board[position.getFile()][position.getRank()] = piece;
        }
    }

    public void movePiece(Position fromPosition, Position toPosition) {
        if (isValidPosition(fromPosition) && isValidPosition(toPosition)) {
            placePiece(getPiece(fromPosition), toPosition);
            removePiece(fromPosition);
        }
    }

    public void removePiece(Position position) {
        if (isValidPosition(position)) {
            this.board[position.getFile()][position.getRank()] = null;
        }
    }

    public String displayBoard() {
        StringBuilder sb = new StringBuilder();
        for (int file = 0; file < this.board.length; ++file) {
            for (int rank = 0; rank < this.board[file].length; ++rank) {
                Piece piece = this.board[file][rank];
                if (piece != null) {
                    sb.append(piece.getName().charAt(0));
                } else {
                    sb.append("-");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
