package com.capgemini.gameoflife;

import java.util.List;

public class Cell {
	private boolean isAlife;
	private Position pos;
	private boolean nextState;
	private List<Cell> listOfNeightbours;

	public Cell(boolean isAlife, Position pos) {
		super();
		this.isAlife = isAlife;
		this.pos = pos;

	}

	public void calculateNextState() {
		int counter = 0;
		for (Cell cell : listOfNeightbours) {
			if (cell.isAlife) {
				counter+=1;
			}
		}

		if (isAlife){
			switch(counter){
			case 2:
				nextState =true;
				break;
			case 3:
				nextState =true;
				break;
			default:
				nextState = false;
				break;
			
			}
			
		}
		
		if (!isAlife && counter == 3) {
			nextState = true;
			return;
		}
	}
	
	public void updateState(){
		this.isAlife=this.nextState;
	}

	public boolean isAlife() {
		return isAlife;
	}


	public Position getPos() {
		return pos;
	}



	private boolean isNextState() {
		return nextState;
	}




	public void setListOfNeightbours(List<Cell> listOfNeightbours) {
		this.listOfNeightbours = listOfNeightbours;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		 boolean result;
	
		        Cell cell = (Cell)obj;
		        result = this.pos.equals(cell.getPos()) &&  this.isAlife==cell.isAlife() &&  this.isNextState()==cell.isNextState() ;
		    return result;
		} 
	


}
