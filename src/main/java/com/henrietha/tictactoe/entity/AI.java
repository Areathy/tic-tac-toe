package com.henrietha.tictactoe.entity;

import java.util.ArrayList;
import java.util.Random;

public class AI {

    public int pickSpot(TicTacToe game) {
        ArrayList<Integer> choices = new ArrayList<>();
        for (int i=0; i<9; i++) {
            //add available slot as a choice
            if (game.board[i] == '-') {
                choices.add(i +1);
            }
        }
        Random random = new Random();
        int choice = choices.get(Math.abs(random.nextInt() % choices.size()));
        return choice;
    }

}
