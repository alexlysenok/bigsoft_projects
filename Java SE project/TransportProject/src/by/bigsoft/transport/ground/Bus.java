package by.bigsoft.transport.ground;


public class Bus extends Ground{

	public Bus(){}

	
	public Bus(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception {
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}

}
