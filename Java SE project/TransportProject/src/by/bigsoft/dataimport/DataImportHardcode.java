package by.bigsoft.dataimport;

import java.util.ArrayList;
import java.util.List;

import by.bigsoft.city.City;
import by.bigsoft.transport.Transport;
import by.bigsoft.transport.air.Helicopter;
import by.bigsoft.transport.air.Plane;
import by.bigsoft.transport.ground.Bus;
import by.bigsoft.transport.ground.Car;
import by.bigsoft.transport.sea.Boat;
import by.bigsoft.transport.sea.Ship;


public class DataImportHardcode implements IDataImport {

	
	@Override
	public List<Transport> loadTransports() throws Exception {
		List<Transport> hardcodeTransport = new ArrayList<Transport>();
		
		hardcodeTransport.add(new Helicopter("Ветролет", 220.0, 10, 100, 0.01, 0.001));
		hardcodeTransport.add(new Plane("Самолет", 300.0, 200, 1000, 0.02, 0.001));
		hardcodeTransport.add(new Bus("Автобус №1", 70.0, 50, 50, 0.1, 0.001));
		hardcodeTransport.add(new Bus("Автобус №2", 60.0, 60, 60, 0.02, 0.001));
		hardcodeTransport.add(new Car("Автомобиль №1", 100.0, 4, 20, 0.006, 0.0001));
		hardcodeTransport.add(new Car("Автомобиль №1", 90.0, 4, 30, 0.008, 0.0001));
		hardcodeTransport.add(new Boat("Моторная лодка", 80.0, 5, 10, 0.001, 0.0));
		hardcodeTransport.add(new Ship("Теплоход", 60.0, 2000, 10000, 0.002, 0.01));
		return hardcodeTransport;
	}

	
	@Override
	public List<City> loadCities() throws Exception {
		List<City> hardcodeCities = new ArrayList<City>();
		hardcodeCities.add(new City("Амсердам", 52.3740300, 4.8896900, true, true, true));
		hardcodeCities.add(new City("Берлин", 52.5243700, 13.4105300, true, false, true));
		hardcodeCities.add(new City("Венеция", 45.4371300, 12.3326500, false, true, true));
		hardcodeCities.add(new City("Осло", 59.9127300, 10.7460900, true, true, true));
		hardcodeCities.add(new City("Париж", 48.8534100, 2.3488000, true, false, true));
		return hardcodeCities;
	}

   
    
}
