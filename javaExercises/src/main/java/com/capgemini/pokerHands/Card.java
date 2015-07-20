package com.capgemini.pokerHands;

public class Card {
	
	private CardValues value;
	private CardColors color;
	
	public CardValues getValue() {
		return value;
	}

	public void setValue(CardValues value) {
		this.value = value;
	}

	public CardColors getColor() {
		return color;
	}

	public void setColor(CardColors color) {
		this.color = color;
	}

}
