package com.capgemini.gameoflife;

public class Position {
	
	private int posx;
	private int posy;
	
	public int getPosx() {
		return posx;
	}

	public int getPosy() {
		return posy;
	}

	public Position(int posx, int posy) {
		super();
		this.posx = posx;
		this.posy = posy;
	}

	@Override
	public boolean equals(Object other){
	    boolean result;
	   /* if((other == null) || (getClass() != other.getClass())){
	        result = false;
	    } */
	    
	        Position pos = (Position)other;
	        result = this.posx==pos.getPosx() &&  this.posy==pos.getPosy() ;
	    

	    return result;
	} 

	@Override
	public int hashCode() {
		return posx*50+posy;
	}
	
	

}
