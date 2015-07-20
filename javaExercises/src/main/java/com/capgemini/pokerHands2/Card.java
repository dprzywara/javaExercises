package com.capgemini.pokerHands2;

import com.capgemini.pokerHands2.Colors;
import com.capgemini.pokerHands2.CardValues;

public class Card {

	private CardValues Cvalue;
	private Colors color;

	public CardValues getCvalue() {
		return Cvalue;
	}

	public void setValue(CardValues value) {
		this.Cvalue = value;
	}

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}

}
