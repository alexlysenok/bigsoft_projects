package by.bigsoft.transport.air;

import by.bigsoft.transport.*;


public class Air extends Transport{

	public Air(){
		
	}
	
	public Air(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception {
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}

	
}
