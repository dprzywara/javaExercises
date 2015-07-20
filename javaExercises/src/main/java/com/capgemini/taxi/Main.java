package com.capgemini.taxi;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		User user1 = new User(1,new Position(0,0));
		User user2 = new User(2,new Position(200,500));
		User user3 = new User(3,new Position(600,100));
		
		Server server=new Server();
		server.start();
		
			Thread.sleep(3000);
			user1.setSubscribe(true);
			Thread.sleep(5000);
			user2.setSubscribe(true);
			Thread.sleep(7000);
			user3.setSubscribe(true);
			Thread.sleep(2000);
			user3.setSubscribe(false);
			Thread.sleep(9000);
			user3.setSubscribe(true);
		//}
		
		//while(licznik<3){
/*		while(true){
			Thread.sleep(3000);
			//user.findTaxi(server);
			for (TaxiData t : user1.getListOfnearestTaxi()) {
				t.distance(user1);
			}
			System.out.println("User1"+user1.getListOfnearestTaxi().toString());
			for (TaxiData t : user2.getListOfnearestTaxi()) {
				t.distance(user2);
			}
			
			System.out.println("User2"+user2.getListOfnearestTaxi().toString());
			
			//licznik++;
		}*/
		
		//stop=false;
		}
		
		
	

}
