package com.capgemini.pokerHands2;

import com.capgemini.pokerHands2.CardValues;

public enum CardValues {

	TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9",
			9), TEN("T", 10), JACK("J", 11), QUEEN("Q", 12), KING("K", 13), ACE("A", 14);

	int value;
	String symbol;

	private CardValues(String s, int v) {
		value = v;
		symbol = s;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public static CardValues selectValue(String string) {
		for (CardValues v : CardValues.values()) {
			if (string.equals(v.symbol)) {
				return v;
			}
		}
		return null;
	}

}
