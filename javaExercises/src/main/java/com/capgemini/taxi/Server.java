package com.capgemini.taxi;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Server extends Thread {
	private static final int numberOfTaxi = 1000;
	private static final int numberOfNearestTaxi = 5;
	private LinkedList<Taxi> listOfTaxi = new LinkedList<Taxi>();
	private static LinkedList<User> listOfUsers = new LinkedList<User>();

	public Server() {
		for (int i = 0; i < numberOfTaxi; i++) {
			listOfTaxi.add(new Taxi());
			listOfTaxi.get(i).start();
		}
	}

	public LinkedList<TaxiData> findNearestTaxiForUser(User u) {
		LinkedList<TaxiData> copyOfTaxiList = makeCopyListOfTaxi(u);
		Collections.sort(copyOfTaxiList, new DistanceComparator(u.getPos()));
		if (copyOfTaxiList.size() <= numberOfNearestTaxi) {
			return copyOfTaxiList;
		}
		return (LinkedList<TaxiData>) copyOfTaxiList.subList(0, numberOfNearestTaxi - 1);

	}

	private LinkedList<TaxiData> makeCopyListOfTaxi(User u) {
		LinkedList<TaxiData> templistOfTaxiData = new LinkedList<TaxiData>();
		
		for (Taxi taxi : listOfTaxi) {
			if (!taxi.isBusy() && (DistanceComparator.calculateDistance(u.getPos(), taxi.getPos()) < 1000)) {
				TaxiData td = new TaxiData();
				td.setId((int) taxi.getId());
				td.setPos(taxi.getPos());
				templistOfTaxiData.add(td);
			}
		}
		return templistOfTaxiData;
		
	}

	private void checkChanges() {
		for (User user : listOfUsers) {
			LinkedList<TaxiData> newlistOfTaxi = new LinkedList<TaxiData>();
			newlistOfTaxi = findNearestTaxiForUser(user);
			if (!compareListOfTaxi(user.getListOfnearestTaxi(), newlistOfTaxi)) {
				user.update(newlistOfTaxi);
			}
		}
	}

	private boolean compareListOfTaxi(List<TaxiData> listOfnearestTaxi, LinkedList<TaxiData> newlistOfTaxi) {

		if (listOfnearestTaxi.size() != newlistOfTaxi.size()) {
			return false;
		}

		for (int i = 0; i < newlistOfTaxi.size(); i++) {
			if (listOfnearestTaxi.get(i).getId() != newlistOfTaxi.get(i).getId()) {
				return false;
			}

		}
		return true;
	}

	public static void updateListOfSubscribeUsers(User u) {
		if (u.isSubscribe()) {
			addSubscribeForUser(u);
			return;
		}
		if (!u.isSubscribe()) {
			removeSubscriptionForUser(u);
			return;
		}

	}
	
	private static void addSubscribeForUser(User u) {
		if (!listOfUsers.contains(u)) {
			listOfUsers.add(u);
		}
	}

	private static void removeSubscriptionForUser(User u) {
		if (listOfUsers.contains(u)) {
			listOfUsers.remove(u);
		}

	}

	public void run() {

		while (true) {
			checkChanges();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
