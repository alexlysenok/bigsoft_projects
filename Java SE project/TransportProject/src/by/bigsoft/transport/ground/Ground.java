package by.bigsoft.transport.ground;

import by.bigsoft.transport.*;


public class Ground extends Transport {

	public Ground(){}
	public Ground(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception {
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}
	
	
}
