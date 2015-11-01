package by.bigsoft.transport.ground;


public class Car extends Ground{

	public Car(){
		
	}
	
	public Car(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception {
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}

}
