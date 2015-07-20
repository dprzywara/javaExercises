package com.capgemini.taxi;

import java.util.Comparator;

public class DistanceComparator implements Comparator<TaxiData> {

	Position userPosition;

	public DistanceComparator(Position p) {
		this.userPosition = p;

	}

	public int compare(TaxiData o1, TaxiData o2) {
		
		return calculateDistance(userPosition, o1.getPos())-calculateDistance(userPosition, o2.getPos());
	}
	
	public static int calculateDistance(Position u, Position t){

		return (int)Math.sqrt(Math.pow((t.getPosx()-u.getPosx()),2)+Math.pow(t.getPosy()-u.getPosy(),2));
		
	}
}
