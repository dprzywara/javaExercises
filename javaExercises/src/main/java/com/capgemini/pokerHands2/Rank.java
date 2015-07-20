package com.capgemini.pokerHands2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class Rank {

	private Map<CardValues, Integer> handsRanked = new HashMap<CardValues, Integer>();
	private LinkedList<Integer> listOfOccurance = new LinkedList<Integer>();
	private LinkedList<CardValues> listOfOccuranceValues = new LinkedList<CardValues>();
	private boolean isColor;
	private Ranks ran;
	

	public LinkedList<Integer> parseToList() {
		LinkedList<Integer> occurance = new LinkedList<Integer>();
		occurance.addAll(handsRanked.values());
		Collections.sort(occurance);
		Collections.reverse(occurance);
		return occurance;
	}



	public LinkedList<CardValues> parseToSortedList() {
		LinkedList<CardValues> sorted = new LinkedList<CardValues>();
		List<CardValues> listToSort = new ArrayList<CardValues>();
		Set<Integer> uniqueOccurance = new HashSet<Integer>(listOfOccurance);
																						
		List<Integer> entrylist = new ArrayList<Integer>(uniqueOccurance);
		Collections.sort(entrylist);
		Collections.reverse(entrylist);

		for (Integer occ : entrylist) {
			for (Entry<CardValues, Integer> entry : handsRanked.entrySet()) {
				if (entry.getValue().equals(occ)) {
					listToSort.add(entry.getKey());
				}
			}
			listSort(listToSort);
			sorted.addAll(listToSort);
			listToSort.clear();
		}
		return sorted;
	}
	private void listSort(List<CardValues> listToSort) {
		CardValues temp;
		for (int j = 0; j < listToSort.size(); j++) {
			for (int i = 0; i < listToSort.size() - j - 1; i++) {
				if (listToSort.get(i).value < listToSort.get(i + 1).value) {

					temp = listToSort.get(i);
					listToSort.set(i, listToSort.get(i + 1));
					listToSort.set(i + 1, temp);
				}
			}
		}

	}
	public LinkedList<Integer> getListOfOccurance() {
		return listOfOccurance;
	}

	public void setListOfOccurance(LinkedList<Integer> listOfOccurance) {
		this.listOfOccurance = listOfOccurance;
	}

	public LinkedList<CardValues> getListOfOccuranceValues() {
		return listOfOccuranceValues;
	} 

	public void setListOfOccuranceValues(LinkedList<CardValues> listOfOccuranceValues) {
		this.listOfOccuranceValues = listOfOccuranceValues;
	}

	public Ranks getRan() {
		return ran;
	}

	public void setRan(Ranks ran) {
		this.ran = ran;
	}

	public List<Integer> getOccurance() {
		return listOfOccurance;

	}

	public void setOccurance(LinkedList<Integer> occurance) {
		this.listOfOccurance = occurance;
	}

	public boolean getIsColor() {
		return isColor;
	}

	public void setColor(boolean isColor) {
		this.isColor = isColor;
	}

	public enum Ranks {

		HIGH_CARD(0), ONE_PAIR(1), TWO_PAIRS(2), THREE_OF_KIND(3), Straight(4), Flush(5), Full_House(6), Four_of_Kind(
				7), Straight_Flush(8), Royal_Flush(9);

		int val;

		private Ranks(int t) {
			val = t;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int v) {
			this.val = v;
		}

	}

	/////
	public Map<CardValues, Integer> getHandsRanked() {
		return handsRanked;
	}

	public void setHandsRanked(Map<CardValues, Integer> hr) {
		handsRanked = hr;
	}

	public void selectRank() {

		if (listOfOccurance.equals(Arrays.asList(2, 2, 1))) {
			ran = Ranks.TWO_PAIRS;
			return;
		}
		if (listOfOccurance.equals(Arrays.asList(2, 1, 1, 1))) {
			ran = Ranks.ONE_PAIR;
			return;
		}
		if (listOfOccurance.equals(Arrays.asList(3, 1, 1))) {
			ran = Ranks.THREE_OF_KIND;
			return;
		}
		if (listOfOccurance.equals(Arrays.asList(3, 2))) {
			ran = Ranks.Full_House;
			return;
		}
		if (listOfOccurance.equals(Arrays.asList(4, 1))) {
			ran = Ranks.Four_of_Kind;
			return;
		}

		if (listOfOccurance.equals(Arrays.asList(1, 1, 1, 1, 1))) {

			if (listOfOccuranceValues.getFirst().value - listOfOccuranceValues.getLast().value == 4) {

				if (isColor) {

					if (handsRanked.containsKey(CardValues.ACE)) {
						ran = Ranks.Royal_Flush;
					} else {
						ran = Ranks.Straight_Flush;

					}
					return;
				}
				ran = Ranks.Straight;
				return;
			}

			if (isColor) {
				ran = Ranks.Flush;
				return;
			}

			ran = Ranks.HIGH_CARD;
			return;
		}

	}
}
