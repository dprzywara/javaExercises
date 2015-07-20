package com.capgemini.taxi;

import java.util.Random;

public class Taxi extends Thread {
	private Position pos;
	private boolean isBusy;
	private static final int cityWidth = 20000;
	private static final int cityLength = 20000;
	private final int maxMoveRangeX = -20;
	private final int maxMoveRangeY = 20;

	public Taxi(Position p, boolean isBusy) {
		super();
		this.pos = p;
		this.isBusy = isBusy;
	}

	public Taxi() {
		Random rand = new Random();
		this.pos = new Position(rand.nextInt(cityWidth), rand.nextInt(cityLength));
		this.isBusy = false;
	}

	public Position getPos() {
		return pos;
	}

	public boolean isBusy() {
		return isBusy;
	}

	public void run() {
		Random r = new Random();
		int newPosition = 0;
		int iter=0;
		while (true) {
			newPosition = pos.getPosx() + r.nextInt(maxMoveRangeY - maxMoveRangeX + 1) + maxMoveRangeX;
			if (newPosition < cityWidth && newPosition >= 0 ) {
				pos.setPosx(newPosition);
			}
			newPosition = pos.getPosy() + r.nextInt(maxMoveRangeY - maxMoveRangeX + 1) + maxMoveRangeX;
			if (newPosition < cityLength && newPosition >= 0 ) {
				pos.setPosy(newPosition);
			}
			
			if(iter==4){
				isBusy=r.nextBoolean();
				iter=0;
			}
						
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			iter++;
		//	System.out.println("taxi " + getId() + " pos:(" + pos.getPosx() + "," + pos.getPosy() + ") " + isBusy());
		}

	}
	
	@Override
	public String toString() {
		return "Taxi nr " + getId() + pos ;
	}

}
