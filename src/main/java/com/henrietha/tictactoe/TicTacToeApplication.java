package com.henrietha.tictactoe;

import com.henrietha.tictactoe.entity.AI;
import com.henrietha.tictactoe.entity.TicTacToe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {
	public static void main(String[] args) {

		SpringApplication.run(TicTacToeApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		boolean doYouWantToPay = true;

		while (doYouWantToPay) {
			System.out.println("Welcome. Please select your character and mine");
			System.out.println();
			System.out.println("Please enter a single character that will represent you.");
			char playersToken = scanner.next().charAt(0);
			System.out.println("Please enter a single character that will represent me");
			char cpuToken = scanner.next().charAt(0);
			TicTacToe game = new TicTacToe(playersToken, cpuToken);
			AI ai = new AI();

			//Set up
			System.out.println();
			System.out.println("Let's start.");
			TicTacToe.printIndexBoard();
			System.out.println();

			//Let's play
			while (game.gameOver().equals("notOver")) {
				if (game.currentMarker == game.userMarker) {
					//User turn
					System.out.println("Your turn");
					int spot = scanner.nextInt();
					while (!game.playTurn(spot)) {
						System.out.println(spot + "not available");
						spot = scanner.nextInt();
					}
					System.out.println("You picked" + spot + "!");
				} else {
					//CPU turn
					System.out.println("It's my turn");
					int aiSpot = ai.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println("I picked" + aiSpot +"!");
				}
				//Print out new board
				System.out.println();
				game.printBoard();
			}
			System.out.println(game.gameOver());
			System.out.println();

			//Set up new game...or not
			System.out.println("Replay? Enter y if you do or anything else if you don't. ");
			char response = scanner.next().charAt(0);
			doYouWantToPay = (response == 'y');
			System.out.println();
			System.out.println();
		}
	}

}
