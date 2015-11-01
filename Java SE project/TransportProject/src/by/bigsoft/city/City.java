package by.bigsoft.city;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	
    
	
    @XmlElement(name="name")
	private String name;
	
    @XmlElement(name="width")
	private double width;
	
    @XmlElement(name="length")
	private double length;
	
    @XmlElement(name="hasAirport")
	private boolean hasAirport;
	
    @XmlElement(name="hasPort")
	private boolean hasPort;
	
    @XmlElement(name="hasStation")
	private boolean hasStation;
    
    public City(){
    	
    }
	
	public City(String name, double width, double length, boolean hasAirport, boolean hasPort, boolean hasStation) throws Exception {
		this.name = name;
		setwidth(width);
		setlength(length);
		this.hasAirport = hasAirport;
		this.hasPort = hasPort;
		this.hasStation = hasStation;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getwidth() {
		return width;
	}
	
	public void setwidth(Double width) throws Exception {
		if (width >= -90 && width <= 90) {
			this.width = width;
		} else {
			throw new Exception("Ўирота должна быть в диапазоне от -90 до 90!");
		}
	}
	
	public double getlength() {
		return length;
	}
	
	public void setlength(Double length) throws Exception {
		if (length >= -180 && length <= 180) {
			this.length = length;
		} else {
			throw new Exception("ƒолгота должна быть в диапазоне от -180 до 180!");
		}
	}
	
	public boolean isHasAirport() {
		return hasAirport;
	}
	
	public void setHasAirport(boolean hasAirport) {
		this.hasAirport = hasAirport;
	}
	
	public boolean isHasPort() {
		return hasPort;
	}
	
	public void setHasPort(boolean hasPort) {
		this.hasPort = hasPort;
	}
	
	public boolean isHasStation() {
		return hasStation;
	}
	
	public void setHasStation(boolean hasStation) {
		this.hasStation = hasStation;
	}
	
	
	
	
}
