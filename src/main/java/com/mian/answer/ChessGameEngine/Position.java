package com.mian.answer.ChessGameEngine;

public class Position {
    private int rank, file;

    public Position(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }
}
