package by.bigsoft.transport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
abstract public class Transport{

	
    @XmlElement(name="speed")
	private double speed;
	
    @XmlElement(name="passengerCapacity")
	private int passengerCapacity;
	
    @XmlElement(name="cargoCapacity")
	private double cargoCapacity;
	
    @XmlElement(name="priceperkm")
	private double pricePerKM;
	
    @XmlElement(name="priceperkg")
	private double pricePerKG;
	
    @XmlElement(name="name")
	private String name;
    
   
    public Transport() {
    	
    }
	
	public Transport(String name, double speed, int passengerCapacity, double cargoCapacity, double pricePerKM, double pricePerKG) throws Exception{
		this.name = name;
		setSpeed(speed);
		this.passengerCapacity = passengerCapacity;
		this.cargoCapacity = cargoCapacity;
		this.pricePerKG = pricePerKG;
		this.pricePerKM = pricePerKM;
	}
	
	public double getcargoCapacity() {
		return cargoCapacity;
	}
	
	public int getpassengerCapacity() {
		return passengerCapacity;
	}
	
	public double getPricePerKG() {
		return pricePerKG;
	}
	
	
	public double getPricePerKM() {
		return pricePerKM;
	}

	public double getSpeed() {
		return speed;
	}
	
	public void setcargoCapacity(double cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}
	
	public void passengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	
	public void setPricePerKG(double pricePerKG) {
		this.pricePerKG = pricePerKG;
	}
	
	public void setPricePerKM(double pricePerKM) {
		this.pricePerKM = pricePerKM;
	}
	
	public void setSpeed(double speed) throws Exception {
		if (speed > 0) {
			this.speed = speed;
		} else {
			throw new Exception("Скорость должна быть больше нуля!");
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
