package com.capgemini.pokerHands;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Rank implements Comparable<Rank> {

	private TreeMap<CardValues, Integer> sortedMapOfOccurance = new TreeMap<CardValues, Integer>();
	private boolean isColor;
	

	public TreeMap<CardValues, Integer> getSortedMapOfOccurance() {
		return sortedMapOfOccurance;
	}

	public void setColor(boolean isColor) {
		this.isColor = isColor;
	}

	public boolean isColor() {
		return isColor;
	}

	public void setSortedMapOfOccurance(TreeMap<CardValues, Integer> sortedMapOfOccurance) {
		this.sortedMapOfOccurance = sortedMapOfOccurance;
	}

	public TreeMap<CardValues, Integer> sortMapOfOccurance(Map<CardValues, Integer> map) {
		TreeMap<CardValues, Integer> sortedMap = new TreeMap<CardValues, Integer>(new OccuranceComparator(map));
		sortedMap.putAll(map);
		sortedMapOfOccurance = sortedMap;
		return sortedMap;
	}

	private boolean isConsecutive() {

		return sortedMapOfOccurance.firstKey().ordinal() - sortedMapOfOccurance.lastKey().ordinal() == 4;

	}

	public int compareTo(Rank p2) {
		int size1 = this.sortedMapOfOccurance.size();
		int size2 = p2.sortedMapOfOccurance.size();
		int occurance1,occurance2;
		Iterator<Integer> iterP1 = this.sortedMapOfOccurance.values().iterator();
		Iterator<Integer> iterP2 = p2.sortedMapOfOccurance.values().iterator();
		
		while (iterP1.hasNext()) {
			occurance1 = iterP1.next();
			occurance2 = iterP2.next();
			if (size1 == 5 && size2 == 5) {
				if(compareSize5(p2)!=0){
					return compareSize5(p2);
				}
			}

			if (size1 == 5) {
				if(compareAccordingP2size(size2)!=0)
				return compareAccordingP2size(size2);
			}
			if (size2 == 5) {
				if(compareAccordingP1size(p2, size1)!=0)
					return compareAccordingP1size(p2, size1);
			}
			if (occurance1 > occurance2) {
				return PokerGame.PLAYER1;

			}
			if (occurance1 < occurance2) {
				return PokerGame.PLAYER2;
			}
		}
		return solveTie(p2);
	}

	private int compareSize5(Rank p2) {
		if (this.isColor) {
			if (p2.isColor) {
				if(compareConsecutive(p2)!=0)
					return compareConsecutive(p2);
			}
			return PokerGame.PLAYER1;

		}
		if (p2.isColor) {
			return PokerGame.PLAYER2;
		}
		if(compareConsecutive(p2)!=0)
		return compareConsecutive(p2);
		
		return 0;
	}

	private int compareAccordingP1size(Rank p2, int size1) {
		switch (size1) {
		case 2:
			if (!(p2.isColor && p2.isConsecutive())) {
				return PokerGame.PLAYER1;
			}
			return PokerGame.PLAYER2;

		case 3:
			if (p2.isColor || p2.isConsecutive()) {
				return PokerGame.PLAYER2;
			}
			return PokerGame.PLAYER1;

		case 4:
			if (!p2.isColor && !p2.isConsecutive()) {
				return PokerGame.PLAYER1;
			}
			return PokerGame.PLAYER2;

		}
		return 0;
	}

	private int compareAccordingP2size(int size2) {
		switch (size2) {
		case 2:
			if (!(this.isColor && this.isConsecutive())) {
				return PokerGame.PLAYER2;
			}
			return PokerGame.PLAYER1;

		case 3:
			if (this.isColor || this.isConsecutive()) {
				return PokerGame.PLAYER1;
			}
			return PokerGame.PLAYER2;

		case 4:
			if (!this.isColor && !this.isConsecutive()) {
				return PokerGame.PLAYER2;
			}
			return PokerGame.PLAYER1;

		}
		return 0;
	}

	private int compareConsecutive(Rank p2) {
		if (this.isConsecutive() && !p2.isConsecutive()) {
			return PokerGame.PLAYER1;
		}
		if (!this.isConsecutive() && p2.isConsecutive()) {
			return PokerGame.PLAYER2;
		}
		return 0;
	}

	private int solveTie(Rank p2) {
		boolean isWinner = false;
		CardValues player1Card;
		CardValues player2Card;
		Iterator<CardValues> iterP1 = this.sortedMapOfOccurance.keySet().iterator();
		Iterator<CardValues> iterP2 = p2.sortedMapOfOccurance.keySet().iterator();
		while (!isWinner) {
			player1Card = iterP1.next();
			player2Card = iterP2.next();
			for (int i = 0; i < 5; i++) {
				if (player1Card != player2Card) {
					isWinner = true;
					if (player1Card.ordinal() > player2Card.ordinal()) {
						return PokerGame.PLAYER1;
					} 
						return PokerGame.PLAYER2;
				}
			}

		}
		return PokerGame.TIE;
	}

}
