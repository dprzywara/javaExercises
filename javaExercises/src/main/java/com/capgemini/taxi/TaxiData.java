package com.capgemini.taxi;



public class TaxiData {
	
	int id;
	Position pos;
	//int distance=-12;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}

	/*void  distance(User u){
		distance= DistanceComparator.calculateDistance(u.getPos(), getPos());
	}*/
	@Override
	public String toString() {
		//return "Taxi nr " + id+" " + pos + "d: "+distance;
		return "Taxi nr " + id+" " + pos ;
	}
	/*@Override
	public boolean equals(Object obj) {
		 boolean result;
		    if((obj == null) || (getClass() != obj.getClass())){
		        result = false;
		    } 
		   
		        TaxiData td = (TaxiData)obj;
		        result = this.id==td.getId();
		   

		    return result;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}*/
	
	
}
