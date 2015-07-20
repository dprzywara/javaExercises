package com.capgemini.pokerHands2;

public enum Colors {

	SPADES("S"), HEART("H"), DIAMOND("D"), CLUB("C");
	String representation;

	private Colors(String t) {
		representation = t;
	} 

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String representation) {
		this.representation = representation;
	}

	public static Colors selectColor(String string) {
		for (Colors c : Colors.values()) {
			if (string.equals(c.representation)) {
				return c;
			}
		}
		return null;
	}

}
