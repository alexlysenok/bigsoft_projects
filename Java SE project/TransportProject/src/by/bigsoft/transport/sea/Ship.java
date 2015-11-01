package by.bigsoft.transport.sea;


public class Ship extends Sea {

	public Ship(){
		
	}
	
	public Ship(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception {
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}

}
