package by.bigsoft.logiticcenter;

import java.util.ArrayList;
import java.util.List;



import by.bigsoft.transport.*;
import by.bigsoft.transport.air.*;
import by.bigsoft.transport.ground.*;
import by.bigsoft.transport.sea.*;
import by.bigsoft.city.*;
import by.bigsoft.dataimport.IDataImport;


public class LogisticCenter {

	
	private IDataImport dataImport;
	
	private List<Transport> createTransports;
	
	private List<City> createCities;
	
	
	public LogisticCenter(IDataImport dI) throws Exception {

       
		dataImport = dI;
		createTransports=(ArrayList<Transport>) createTransports();
		createCities=(ArrayList<City>) createCities();
		
		
		
	}
	
	public List<Transport> createTransports() throws Exception {
		createTransports = dataImport.loadTransports();
		return createTransports;
		
	}

	public List<City> createCities() throws Exception {
		createCities = dataImport.loadCities();
		return createCities;
	}
	
	public boolean getCityByAir(City start) {

		if (start.isHasAirport() == true) {
			String str = start.getName();
			System.out.print("Можно ли добраться до города " + str
					+ " по воздуху?: ");
			return true;
		} else {
			String str = start.getName();
			System.out.print("Можно ли добраться до города " + str
					+ " по воздуху?: ");
			return false;
		}
	}

	public boolean getCityByGround(City start) {
		String str = start.getName();
		System.out
				.print("Можно ли добраться до города " + str + " по земле?: ");
		return true;
	}

	public boolean getCityBySea(City start) {
		if (start.isHasPort() == true) {
			String str = start.getName();
			System.out.print("Можно ли добраться до города " + str
					+ " по морю?: ");
			return true;
		} else {
			String str = start.getName();
			System.out.print("Можно ли добраться до города " + str
					+ " по морю?: ");
			return false;
		}
	}

	public double calculateDistance(City start, City end, boolean a) {

		double dist = Math.hypot(start.getwidth() - end.getwidth(),
				start.getlength() - end.getlength());
		String str1 = start.getName();
		String str2 = end.getName();

		if (a == true) {
			System.out.print("Расстояние между городом " + str1 + " и городом "
					+ str2 + ": ");
		}
		return dist*111;

	}

	public double calculatePrice(City start, City end, Transport transport) {
		double price1 = calculateDistance(start, end, false);
		double price2 = transport.getPricePerKM();
		double price = price1 * price2;
		System.out.print("Стоимость пути из " + start.getName() + " в "
				+ end.getName() + " на " + transport.getName()
				+ " составляет: ");
		return price;
	}

	public List<Transport> loadTransport(double passengers, double cargo) {
		List<Transport> approachTransport = new ArrayList<Transport>();
		for (int i = 0; i <createTransports.size(); i++) {
			if (createTransports.get(i).getpassengerCapacity() >= passengers
					&& createTransports.get(i).getcargoCapacity() >= cargo) {

				approachTransport.add(createTransports.get(i));
			}
		}
		return approachTransport;
	}
	
	public List<Transport> checkAccessability(City start,City end,double passengers, double cargo){
		List<Transport> readyTransport = new ArrayList<Transport>();
		
			
	 for(int i=0; i< loadTransport(passengers,cargo).size();i++){
		if(loadTransport(passengers,cargo).get(i) instanceof Air  ){
			if(start.isHasAirport()==true && end.isHasAirport()==true){
				readyTransport.add(loadTransport(passengers,cargo).get(i) );
			}
		}
		else if(loadTransport(passengers,cargo).get(i) instanceof Sea ){
			if(start.isHasPort()==true && end.isHasPort()==true){
				readyTransport.add(loadTransport(passengers,cargo).get(i) );
			}
		}
		else if(loadTransport(passengers,cargo).get(i) instanceof Ground){
			readyTransport.add(loadTransport(passengers,cargo).get(i) );
		}
	 }
			
	 return readyTransport;
	}
	
	public Transport getTheCheapestTransport(City start,City end,double passengers, double cargo) {

		Transport theCheapest = checkAccessability(start,end,passengers,cargo).get(0);

		for (int j = 0; j < checkAccessability(start,end,passengers,cargo).size()-1; j++) {

			if (checkAccessability(start,end,passengers,cargo).get(j).getPricePerKM() > checkAccessability(start,end,passengers,cargo).get(
					j + 1).getPricePerKM()) {

				theCheapest = checkAccessability(start,end,passengers,cargo).get(j + 1);

			}
		}

		return theCheapest;
	}
	
	public Transport getTheFastestTransport(City start,City end,double passengers, double cargo) {

		Transport theFastest = checkAccessability(start,end,passengers,cargo).get(0);
		for (int j = 0; j < checkAccessability(start,end,passengers,cargo).size()-1; j++) {

			if (checkAccessability(start,end,passengers,cargo).get(j).getSpeed() < checkAccessability(start,end,passengers,cargo).get(j + 1)
					.getSpeed()) {

				theFastest = checkAccessability(start,end,passengers,cargo).get(j + 1);

			}
		}

		return theFastest;
	}
	
	public String resultConsole(City start,City end, double passengers, double cargo){
        String str2="";
        String str1=('\n'+"Вы можете добраться из города "+start.getName()+" в город "+end.getName()+ " на следующем транспорте:  ");
		for(int i=0;i<checkAccessability(start,end,passengers,cargo).size() ; i++){
		    str2+=checkAccessability(start,end,passengers,cargo).get(i).getName()+", ";		    		    
	} 
		String str3=str1+str2;
		
		
		return str3;	
}
	
	

}
