/**
 * 
 */
package by.bigsoft.dataimport;

import java.util.ArrayList;
import java.util.List;

import by.bigsoft.city.City;
import by.bigsoft.transport.Transport;


public interface IDataImport {

	
	public List<Transport> loadTransports() throws Exception;		
	public List<City> loadCities() throws Exception;

   
 
}
