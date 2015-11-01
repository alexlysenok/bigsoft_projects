package by.bigsoft.transport.air;


public class Plane extends Air{

	public Plane(){
		
	}
	
	public Plane(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception {
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}

}
