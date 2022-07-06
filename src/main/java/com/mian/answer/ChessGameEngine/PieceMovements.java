package com.mian.answer.ChessGameEngine;

import com.mian.answer.ChessPieces.Piece;

public class PieceMovements {
    /**
     * 1) pieces in fromPosition and toPosition must not be same color
     * 2) king must not be already in check
     * 3) king must not lose protection from piece located in fromPosition (unless
     * removes King from check)
     * 4)
     * 
     * @param chessBoard
     * @param fromPosition
     * @param toPosition
     * @return
     */
    private boolean isValidMovement(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        return arePiecesValid(chessBoard.getPiece(fromPosition), chessBoard.getPiece(toPosition));
    }

    private boolean arePiecesValid(Piece fromPiece, Piece toPiece) {
        if (fromPiece == null) {
            return false;
        }
        if (toPiece != null && areColorsSame(fromPiece, toPiece)) {
            return false;
        }

        return true;
    }

    private boolean areColorsSame(Piece fromPiece, Piece toPiece) {
        return fromPiece.getColorIdentifier() == toPiece.getColorIdentifier();
    }

    private boolean areInSameRank(Position fromPosition, Position toPosition) {
        return toPosition.getRank() == fromPosition.getRank();
    }

    private boolean isHorizontalPathToRightClear(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        Piece piece = null;
        for (int rank = fromPosition.getRank() + 1; rank < toPosition.getRank(); ++rank) {
            piece = chessBoard.getPiece(new Position(rank, fromPosition.getFile()));
        }

        return piece == null;
    }

    private boolean isHorizontalPathToLeftClear(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        Piece piece = null;
        for (int rank = fromPosition.getRank() - 1; rank > toPosition.getRank(); --rank) {
            piece = chessBoard.getPiece(new Position(rank, fromPosition.getFile()));
        }

        return piece == null;
    }

    private boolean isHorizontalPathClear(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        return (fromPosition.getRank() - toPosition.getRank() > 0)
                ? isHorizontalPathToRightClear(chessBoard, fromPosition, toPosition)
                : isHorizontalPathToLeftClear(chessBoard, fromPosition, toPosition);
    }

    private boolean isVerticalPathToAboveClear(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        Piece piece = null;
        for (int file = fromPosition.getFile() - 1; file > toPosition.getFile(); --file) {
            piece = chessBoard.getPiece(new Position(fromPosition.getRank(), file));
        }

        return piece == null;
    }

    private boolean isVerticalPathToBelowClear(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        Piece piece = null;
        for (int file = fromPosition.getFile() + 1; file < toPosition.getFile(); ++file) {
            piece = chessBoard.getPiece(new Position(fromPosition.getRank(), file));
        }

        return piece == null;
    }

    private boolean isVerticalPathClear(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        return (fromPosition.getFile() - toPosition.getFile() > 0)
                ? isVerticalPathToAboveClear(chessBoard, fromPosition, toPosition)
                : isVerticalPathToBelowClear(chessBoard, fromPosition, toPosition);
    }
    /**
     * pieces in fromPosition and toPosition must not be same color
     * king must not be already in check
     * 
     * @param chessBoard
     * @param fromPosition
     * @param toPosition
     */
    public void pawnMovement(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        if (!isValidMovement(chessBoard, fromPosition, toPosition)) {
            return;
        }

        // can move forward in file
        if (areInSameRank(fromPosition, toPosition)) {
            // 1 step forward if fromPosition is clear
            if (toPosition.getFile() + 1 == fromPosition.getFile()
                    && chessBoard.getPiece(toPosition) == null) {
                chessBoard.movePiece(fromPosition, toPosition);
            }
            // 2 step forward if path is clear
            else if (toPosition.getFile() + 2 == fromPosition.getFile()) {
                if ((fromPosition.getFile() == 1 || fromPosition.getFile() == 6)
                        && chessBoard.getPiece(new Position(toPosition.getRank(), toPosition.getFile() + 1)) == null
                        && chessBoard.getPiece(toPosition) == null) {
                    chessBoard.movePiece(fromPosition, toPosition);
                }
            }
        }
        // or diagonally if toPosition has a piece
        else if (toPosition.getRank() + 1 == fromPosition.getRank()
                || toPosition.getRank() - 1 == fromPosition.getRank()) {
            if (chessBoard.getPiece(toPosition) != null) {
                chessBoard.movePiece(fromPosition, toPosition);
            }
        }
    }

    public void knightMovement(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        if (!isValidMovement(chessBoard, fromPosition, toPosition)) {
            return;
        }

        int fileDifference = Math.abs(toPosition.getFile() - fromPosition.getFile());
        int rankDifference = Math.abs(toPosition.getRank() - fromPosition.getRank());

        if (fileDifference > 2 || fileDifference < 1 || rankDifference > 2 || rankDifference < 1) {
            return;
        }

        chessBoard.movePiece(fromPosition, toPosition);
    }

    public boolean rookMovement(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        if (!isValidMovement(chessBoard, fromPosition, toPosition)) {
            return false;
        }

        int fromFile = fromPosition.getFile();
        int fromRank = fromPosition.getRank();
        int toFile = toPosition.getFile();
        int toRank = toPosition.getRank();
        // horizontal check
        if (fromFile == toFile && fromRank != toRank) {
            if (isHorizontalPathClear(chessBoard, fromPosition, toPosition)) {
                chessBoard.movePiece(fromPosition, toPosition);
                return true;
            }
        }
        // vertical check
        else if (fromFile != toFile && fromRank == toRank) {
            if (isVerticalPathClear(chessBoard, fromPosition, toPosition)) {
                chessBoard.movePiece(fromPosition, toPosition);
                return true;
            }
        }

        return false;
    }

    public boolean bishopMovement(ChessBoard chessBoard, Position fromPosition, Position toPosition) {
        if (!isValidMovement(chessBoard, fromPosition, toPosition)) {
            return false;
        }

        int fromFile = fromPosition.getFile();
        int fromRank = fromPosition.getRank();
        int toFile = toPosition.getFile();
        int toRank = toPosition.getRank();
        int fileDifference = toFile - fromFile;
        int rankDifference = toRank - fromRank;

        if (Math.abs(fileDifference) != Math.abs(rankDifference)) {
            return false;
        }

        int offset = Math.abs(fileDifference);

        for (int pos = 1; pos < offset; ++pos) {
            int file = (fileDifference < 0) ? fromFile - pos : fromFile + pos;
            int rank = (rankDifference < 0) ? fromRank - pos : fromRank + pos;

            if (chessBoard.getPiece(new Position(rank, file)) != (Piece) null) {
                return false;
            }
        }

        chessBoard.movePiece(fromPosition, toPosition);

        return true;
    }
}
