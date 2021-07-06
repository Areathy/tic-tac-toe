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

    public boolean playTurn(int spot) {
        boolean isValid = withinRange(spot) && !isSpotTaken(spot);
        if(isValid) {
            board[spot-1] = currentMaker;
            currentMaker = (currentMaker == userMarker) ? aiMarker : userMarker;
//            return isValid;
        }
        return isValid;
//        return false;
//        System.out.println("Try again");
    }

    public boolean withinRange(int number) {
        return number > 0 && number < board.length + 1;
    }

    public boolean isSpotTaken(int number) {
        return board[number-1] != '-';
    }

    public void printBoard() {
        // Attempting to create...
        // | - | - | -
        // ------------
        // | - | - | -
        // ------------
        // | - | - | -

        System.out.println();
        for (int i = 0; i<board.length; i++) {
            if(i % 3 == 0 && i !=0) {
                System.out.println();
                System.out.println("------------");
            }
            System.out.println(" | " + board[1]);
        }
        System.out.println();
    }

    public void printIndexBoard() {

        System.out.println();
        for (int i = 0; i<board.length; i++) {
            if(i % 3 == 0 && i !=0) {
                System.out.println();
                System.out.println("------------");
            }
            System.out.println(" | " + (i +1));
        }
        System.out.println();
    }

//    public boolean isThereAWinner() {
//
//    }
}
