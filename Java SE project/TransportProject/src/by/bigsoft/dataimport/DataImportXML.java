package by.bigsoft.dataimport;

import java.io.File;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import by.bigsoft.city.LoadCities;
import by.bigsoft.city.City;
import by.bigsoft.transport.Transport;
import by.bigsoft.transport.LoadTransports;


public class DataImportXML implements IDataImport {

	
	static String xmlFolder = "src-xml";

	@Override
	public ArrayList<Transport> loadTransports() throws Exception {
		ArrayList<Transport> result;

		JAXBContext jc = JAXBContext.newInstance(LoadTransports.class);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema sm = sf.newSchema(new StreamSource(new File(DataImportXML.xmlFolder + File.separator + "transports.xsd")));
		
		Unmarshaller um = jc.createUnmarshaller();
		um.setSchema(sm);
		
		LoadTransports ct = (LoadTransports)um.unmarshal(new File(DataImportXML.xmlFolder + File.separator + "transports.xml"));
		result = (ArrayList<Transport>) ct.getAllTransport();
		
		return result;
	}

	
	@Override
	public ArrayList<City> loadCities() throws Exception {

		ArrayList<City> result;
		
		JAXBContext jc = JAXBContext.newInstance(LoadCities.class);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema sm = sf.newSchema(new StreamSource(new File(DataImportXML.xmlFolder + File.separator + "cities.xsd")));
		
		Unmarshaller um = jc.createUnmarshaller();
		um.setSchema(sm);
		
		LoadCities ct = (LoadCities)um.unmarshal(new File(DataImportXML.xmlFolder + File.separator + "cities.xml"));
		result = (ArrayList<City>) ct.getCities();
		
		return result;
	}

  
    

}
