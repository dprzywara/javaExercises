package com.capgemini.pokerHands;
import java.util.Comparator;
import java.util.Map;

public class OccuranceComparator implements Comparator<CardValues> {

	Map<CardValues, Integer> mapOfOccurance;

	public OccuranceComparator(Map<CardValues, Integer> map) {
		this.mapOfOccurance = map;

	}

	public int compare(CardValues c1, CardValues c2) {
		if(mapOfOccurance.get(c1).equals(mapOfOccurance.get(c2))){
			return c2.ordinal()-c1.ordinal();
		}
		return mapOfOccurance.get(c2)-mapOfOccurance.get(c1);
	}
	
	
}