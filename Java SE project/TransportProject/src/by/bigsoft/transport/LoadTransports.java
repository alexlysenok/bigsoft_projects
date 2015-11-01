package by.bigsoft.transport;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import by.bigsoft.transport.air.Helicopter;
import by.bigsoft.transport.air.Plane;
import by.bigsoft.transport.ground.Bus;
import by.bigsoft.transport.ground.Car;
import by.bigsoft.transport.ground.Ground;
import by.bigsoft.transport.sea.Boat;
import by.bigsoft.transport.sea.Ship;


@XmlRootElement(name="transports")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({Bus.class, Ground.class, Transport.class})
public class LoadTransports {

	private List<Bus> listBus = new ArrayList<Bus>();
	private List<Car> listCar = new ArrayList<Car>();
	private List<Helicopter> listHelicopter = new ArrayList<Helicopter>();
	private List<Plane> listPlane = new ArrayList<Plane>();
	private List<Boat> listBoat = new ArrayList<Boat>();
	private List<Ship> listShip = new ArrayList<Ship>();

	/**
	 * Конструктор
	 */
	public LoadTransports() {
		
	}


	public List<Bus> getListBus() {
		return listBus;
	}

	@XmlElement(name="item")
	@XmlElementWrapper(name="bus")
	public void setListBus(List<Bus> listBus) {
		this.listBus = listBus;
	}

	public List<Car> getListCar() {
		return listCar;
	}

	@XmlElement(name="item")
	@XmlElementWrapper(name="car")
	public void setListCar(List<Car> listCar) {
		this.listCar = listCar;
	}

	public List<Helicopter> getListHelicopter() {
		return listHelicopter;
	}


	@XmlElement(name="item")
	@XmlElementWrapper(name="helicopter")
	public void setListHelicopter(List<Helicopter> listHelicopter) {
		this.listHelicopter = listHelicopter;
	}


	public List<Plane> getListPlane() {
		return listPlane;
	}


	@XmlElement(name="item")
	@XmlElementWrapper(name="plane")
	public void setListPlane(List<Plane> listPlane) {
		this.listPlane = listPlane;
	}


	public List<Boat> getListBoat() {
		return listBoat;
	}


	@XmlElement(name="item")
	@XmlElementWrapper(name="boat")
	public void setListBoat(List<Boat> listBoat) {
		this.listBoat = listBoat;
	}


	public List<Ship> getListShip() {
		return listShip;
	}


	@XmlElement(name="item")
	@XmlElementWrapper(name="ship")
	public void setListShip(List<Ship> listShip) {
		this.listShip = listShip;
	}


	public ArrayList<Transport> getAllTransport(){
		ArrayList<Transport> result = new ArrayList<Transport>();
		result.addAll(listBus);
		result.addAll(listCar);
		result.addAll(listHelicopter);
		result.addAll(listPlane);
		result.addAll(listBoat);
		result.addAll(listShip);
		return result;
	}

}
