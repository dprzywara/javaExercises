package com.capgemini.pokerHands;
import java.util.HashMap;
import java.util.Map;

public class Hand {
	
	private Map<CardValues, Integer> mapOfOccurance = new HashMap<CardValues, Integer>();
	private boolean isColor;
	
	public boolean isColor() {
		return isColor;
	}

	public void setColor(boolean isColor) {
		this.isColor = isColor;
	}

	public Map<CardValues, Integer> getMapOfOccurance() {
		return mapOfOccurance;
	}


	public void countFigures(Card card) {
		int cnt = 0;

			if (mapOfOccurance.containsKey(card.getValue())) {
				cnt = mapOfOccurance.get(card.getValue());
				mapOfOccurance.put(card.getValue(), cnt = cnt + 1);
			} 
			if (!mapOfOccurance.containsKey(card.getValue()))
				mapOfOccurance.put(card.getValue(), 1);

		}

}
