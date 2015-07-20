package com.capgemini.taxi;

import java.util.LinkedList;
import java.util.List;

public class User {
	private int id;
	private Position pos;
	private boolean subscribe;
	private List<TaxiData> listOfnearestTaxi = new LinkedList<TaxiData>();
	
	
	public User(int i,Position pos) {
		super();
		this.id=i;
		this.pos = pos;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
		Server.updateListOfSubscribeUsers(this);
	}


	public List<TaxiData> getListOfnearestTaxi() {
		return listOfnearestTaxi;
	}

	private void setListOfnearestTaxi(List<TaxiData> listOfnearestTaxi) {
		this.listOfnearestTaxi = listOfnearestTaxi;
	}

	public Position getPos() {
		return pos;
	}


	public void setPos(Position p) {
		this.pos = p;
	}

	public void update(LinkedList<TaxiData> newListOfTaxi){
		setListOfnearestTaxi(newListOfTaxi);
		System.out.println("user "+id+getListOfnearestTaxi().toString());
	}

	@Override
	public String toString() {
		return "[listOfnearestTaxi=" + listOfnearestTaxi + "]";
	}

}
