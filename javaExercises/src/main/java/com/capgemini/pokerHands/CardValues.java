package com.capgemini.pokerHands;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum CardValues {
	TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), TEN("T"), JACK("J"), QUEEN(
			"Q"), KING("K"), ACE("A");
	
	private static final Map<String,CardValues> mapOfValues = Collections.unmodifiableMap(initializeMap());
	private final String symbol;

	private CardValues(String s) {
		this.symbol = s;
	}

	private static Map<String,CardValues>  initializeMap() {
	    Map<String,CardValues>  mapOfValues = new HashMap<String,CardValues> ();
	    for (CardValues cv : CardValues.values()) {
	    	mapOfValues.put(cv.symbol, cv);
	    }
	    return mapOfValues;
	}
	
	public static CardValues getValueOf(String s){
		return mapOfValues.get(s);
		
	}

}
