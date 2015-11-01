package by.bigsoft.transport.sea;


public class Boat extends Sea{

	public Boat(){
		
	}
	
	public Boat(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception {
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}

}
