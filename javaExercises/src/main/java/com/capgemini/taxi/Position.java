package com.capgemini.taxi;

public class Position {
	private int posx;
	private int posy;
	
	public Position(int x, int y){
		this.posx=x;
		this.posy=y;
	}
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	@Override
	public String toString() {
		return "P: [" + posx + ", " + posy + "]";
	}
	
	
	
}
