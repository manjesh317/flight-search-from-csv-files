package com.nagarro.FlightSearchManagement.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nagarro.FlightSearchManagement.Repository.FlightDTO;
import com.nagarro.FlightSearchManagement.model.Flight;
@Controller
public class FlightService 
{	
	final File folder = new File("./src/main/resources/com/nagarro");
	static HashSet<String> filenames=new HashSet<String>();
	@Autowired
	private FlightDTO flightDTO;

	
	  public void readFilesOfFolder() throws IOException {
	  listFilesForFolder(folder);	  
	  }	 
	public void listFilesForFolder(final File folder) throws IOException {
		for (final File fileEntry : folder.listFiles()) {			
			if (fileEntry.isDirectory()) {
				 listFilesForFolder(fileEntry);
			} else {
				if (fileEntry.getName().contains(".csv"))
					filenames.add(fileEntry.getName());
			}
		}
		saveFlightData();
	}	
	@Transactional
	 public void saveFlightData() throws IOException
	 {
		 for(String s:filenames) 	
			{
			 String line="";
				String fileLoc = "./src/main/resources/com/nagarro/"+s;
				BufferedReader br=new BufferedReader(new FileReader(fileLoc));
				//To parse CSV input in a format like Excel, as write:
				br.readLine();
				while ((line=br.readLine())!=null) {
					String[] data=line.split("\\|");
					for (String string : data) {
						System.out.print(string+"    ");
					}
					Flight flight=new Flight(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]);					
					System.out.println(flight);					
					flightDTO.save(flight);					
				}			
			}
	 }
	
	//@GetMapping("/searchFlight")
	public List<Flight> showAllFlight(String departureLocation, String arrivalLocation,Date flightDate,String flightClass,String outputPreference)
	{		
		List<Flight> avilableFlight=new ArrayList<Flight>();
		for(Flight f:flightDTO.findAll())
		{
			if (f.getDepartureLocation().equals(departureLocation) && f.getArrivalLocation().equals(arrivalLocation)
					&& f.getFlightClass().equals(flightClass) && !(f.getFlightDate().before(flightDate))) {
				if (flightClass.equals("EB")) {
					double fare = f.getFare();
					f.setFare((fare + fare * 0.40));
				}
				if (f.getSeatAvailability().equals("Y"))
					avilableFlight.add(f);
			}			
		}
		//return flight;
		return sortAvailableFlight(avilableFlight, outputPreference,flightDate);
	}
	private List<Flight> sortAvailableFlight(List<Flight> avilableFlight, String outputPreference, Date flightDate) {		 
			if (outputPreference.equals("fare")) {				
				Collections.sort(avilableFlight, new Comparator<Flight>() {
					public int compare(Flight f1, Flight f2) {
						return f1.getFare().compareTo(f2.getFare());
					}
				});
			} 
			else if (outputPreference.equals("fare_and_flight_duration")) {
				Collections.sort(avilableFlight, new Comparator<Flight>() {
					public int compare(Flight f1, Flight f2) {

						int value1 = f1.getFare().compareTo(f2.getFare());
						if (value1 == 0) {
							return f2.getFlightDuration().compareTo(f1.getFlightDuration());
						}
						return value1;
					}
				});
			}
			return avilableFlight;
		}		
}
