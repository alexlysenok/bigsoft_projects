package by.bigsoft.transport.air;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="helicopter")
@XmlAccessorType(XmlAccessType.FIELD)
public class Helicopter extends Air{

	public Helicopter(){
		
	}
	
	public Helicopter(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception{
		super(name, speed, passengerCapacity, cargoCapacity, pricePerKM, pricePerKG);
	}

}
