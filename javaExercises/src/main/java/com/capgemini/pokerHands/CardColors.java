package com.capgemini.pokerHands;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum CardColors {

	SPADES("S"), HEART("H"), DIAMOND("D"), CLUB("C");

	private static final Map<String, CardColors> mapOfColors = Collections.unmodifiableMap(initializeMap());
	private final String symbol;

	private CardColors(String s) {
		this.symbol = s;
	}

	private static Map<String, CardColors> initializeMap() {
		Map<String, CardColors> mapOfColors = new HashMap<String, CardColors>();
		for (CardColors cv : CardColors.values()) {
			mapOfColors.put(cv.symbol, cv);
		}
		return mapOfColors;
	}

	public static CardColors getValueOf(String s) {
		return mapOfColors.get(s);

	}

}
