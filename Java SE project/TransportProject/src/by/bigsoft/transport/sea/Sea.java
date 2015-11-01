package by.bigsoft.transport.sea;

import by.bigsoft.transport.*;


public class Sea extends Transport{
	
	public Sea(){
		
	}
	
	public Sea(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception {
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}
	

}
