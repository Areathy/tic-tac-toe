package com.henrietha.tictactoe.entity;

public class TicTacToe {
    protected char[] board;
    private final char userMarker;
    protected char aiMarker;
    protected char winner;
    protected char currentMaker;

    public TicTacToe(char[] board, char playerToken, char winner, char currentMaker) {
        this.userMarker = playerToken;
        this.aiMarker = aiMarker;
        this.winner = '-';
        this.board = setBoard();
    }

    public static char[] setBoard() {
        char[] board = new char[9];
        for (int i=0; i <board.length; i++){
            board[i] = '-';
        }
        return board;
    }
}
