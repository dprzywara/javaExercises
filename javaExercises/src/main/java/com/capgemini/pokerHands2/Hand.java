package com.capgemini.pokerHands2;

import java.util.HashMap;
import java.util.Map;

public class Hand {
	
	public Card[] cardTab = new Card[5];
	

	public Card[] getCardTab() {
		return cardTab;
	}
 
	public void setCardTab(Card[] cardTab) {
		this.cardTab = cardTab;
	}
	
	
	public boolean isTheSameColor() {
		
		for(int j=0;j<cardTab.length-1;j++)
		{
			if(!cardTab[j].getColor().equals(cardTab[j+1].getColor())){
				return false;
			}
			
		}
		return true;
		
	}
	
	
	public Map<CardValues, Integer> countFigures() {

		int cnt = 0;
		//Rank tempRank = new Rank();
		Map<CardValues, Integer> tempHandsRanked = new HashMap<CardValues, Integer>();

		for (Card c : cardTab) {

			if (tempHandsRanked.containsKey(c.getCvalue())) {
				cnt = tempHandsRanked.get(c.getCvalue());
				tempHandsRanked.put(c.getCvalue(), cnt = cnt + 1);
			} else {
				tempHandsRanked.put(c.getCvalue(), 1);
			}
		}
		//tempRank.setHandsRanked(tempHandsRanked);
		return tempHandsRanked;
	}


}
