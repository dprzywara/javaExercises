package com.capgemini.pokerHands2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import com.capgemini.pokerHands2.Colors;
import com.capgemini.pokerHands2.CardValues;

public class PokerGame {

	List<String> gameList = new ArrayList<String>();

	Hand player1 = new Hand();
	Hand player2 = new Hand();

	Rank P1rank = new Rank();
	Rank P2rank = new Rank();

	public Hand assignHand(String dat) {
		String splitData[] = dat.split(" ");

		Hand tempHand = new Hand();
		Card[] cardTab = new Card[5];

		for (int i = 0; i < 5; i++) {
			Card tempCard = new Card();

			tempCard.setValue(CardValues.selectValue(Character.toString(splitData[i].charAt(0))));
			tempCard.setColor(Colors.selectColor(Character.toString(splitData[i].charAt(1))));
			cardTab[i] = tempCard;
		}

		tempHand.setCardTab(cardTab);

		return tempHand;

	}

	public Rank createRank(Hand h){
		Rank tempRank=new Rank();
		tempRank.setHandsRanked(h.countFigures());
		tempRank.setColor(h.isTheSameColor());
		tempRank.setOccurance(tempRank.parseToList());
		tempRank.setListOfOccuranceValues(tempRank.parseToSortedList());
		tempRank.selectRank();
		return tempRank;
	}


	

	public void readDataFromFile() throws FileNotFoundException {
		File file = new File("../javaExercises/src/main/java/com/capgemini/pokerHands/poker.txt");
		Scanner read = new Scanner(file);
		while (read.hasNextLine()) {
			gameList.add(read.nextLine());

		}
		read.close();

	}

	public int checkResult(Rank player1, Rank player2) {
		boolean iswinner = false;

		if (player1.getRan().val == player2.getRan().val) {
			while (!iswinner) {
				for (int i = 0; i < 5; i++) {

					if (player1.getListOfOccuranceValues().get(i) != player2.getListOfOccuranceValues().get(i)) {
						iswinner = true;
						if (player1.getListOfOccuranceValues().get(i).value > player2.getListOfOccuranceValues()
								.get(i).value) {
							return 1;
						} else
							return 2;
					}

				}

			}

		}
		if (player1.getRan().val > player2.getRan().val) {
			return 1;
		}
		if (player1.getRan().val < player2.getRan().val) {
			return 2;
		}

		return -1;

	}

	public int countWins() {
		int wins = 0;
		for (String game : gameList) {

			player1 = assignHand(game.substring(0, game.length() / 2));
			player2 = assignHand(game.substring(game.length() / 2 + 1, game.length()));

			P1rank =createRank(player1);
			P2rank =createRank(player2);


			if (checkResult(P1rank, P2rank) == 1) {
				wins++;
			}
		}
		System.out.println("Player 1 won " + wins + " times");
		return wins;

	}

	public static void main(String[] args) throws FileNotFoundException {

		PokerGame poker = new PokerGame();
		poker.readDataFromFile();
		poker.countWins();

	}

}
