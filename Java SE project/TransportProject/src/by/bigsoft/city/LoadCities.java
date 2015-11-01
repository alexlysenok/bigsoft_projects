package by.bigsoft.city;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 Класс обертка для работы с JAXB
 */
@XmlRootElement(name = "cities")
public class LoadCities {

	@XmlElement(name = "city")
	private List<City> cList;

	public LoadCities() {
	}

	public LoadCities(List<City> cList) {
		this.cList = cList;
	}

	public List<City> getCities() {
		return cList;
	}
}
