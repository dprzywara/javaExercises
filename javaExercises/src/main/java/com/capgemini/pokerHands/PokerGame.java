package com.capgemini.pokerHands;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PokerGame {
	public static final int PLAYER1 = 1;
	public static final int PLAYER2 = 2;
	public static final int TIE = 3;

	private List<String> gameList = new ArrayList<String>();
	private Hand Player1Hand = new Hand();
	private Hand Player2Hand = new Hand();
	private Rank Player1Rank = new Rank();
	private Rank Player2Rank = new Rank();

	public Hand assignHand(String dat) {
		String splitData[] = dat.split(" ");// kazdy element to inna karta
		boolean isColor = true;
		CardColors color = null;
		Hand tempHand = new Hand();
		for (int i = 0; i < 5; i++) {
			Card card = new Card();
			card.setValue(CardValues.getValueOf(Character.toString(splitData[i].charAt(0))));
			card.setColor(CardColors.getValueOf(Character.toString(splitData[i].charAt(1))));
			tempHand.countFigures(card);
			if (i == 0) {
				color = card.getColor();
				continue;
			}
			if (!color.equals(card.getColor())) {
				isColor = false;
			}
		}

		tempHand.setColor(isColor);

		return tempHand;

	}

	public Rank createRank(Hand h) {
		Rank tempRank = new Rank();
		tempRank.setSortedMapOfOccurance(tempRank.sortMapOfOccurance(h.getMapOfOccurance()));
		tempRank.setColor(h.isColor());
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

	public int findWinner(Rank Player1, Rank Player2) {
		return Player1.compareTo(Player2);
	}

	public int countWins() {
		int wins = 0;

		for (String game : gameList) {
			Player1Hand = assignHand(game.substring(0, game.length() / 2));
			Player2Hand = assignHand(game.substring(game.length() / 2 + 1, game.length()));
			Player1Rank = createRank(Player1Hand);
			Player2Rank = createRank(Player2Hand);
			if (findWinner(Player1Rank, Player2Rank) == PLAYER1)
				wins++;

		}
		System.out.println("player1 wins " + wins + " times");
		return wins;

	}
}
