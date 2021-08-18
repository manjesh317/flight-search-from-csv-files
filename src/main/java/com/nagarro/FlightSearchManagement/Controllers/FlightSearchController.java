package com.nagarro.FlightSearchManagement.Controllers;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.FlightSearchManagement.Repository.FlightDTO;
import com.nagarro.FlightSearchManagement.model.Flight;
import com.nagarro.FlightSearchManagement.service.FlightService;

@Controller
public class FlightSearchController {
	@Autowired
	FlightDTO dto;
	@Autowired
	FlightService flightService;
	
	@GetMapping(path = "/flights" )
	@ResponseBody
	public List<Flight> getFlights()
	{
		
		return dto.findAll();
		
	}	
	@GetMapping("/searchFlight")
	public String showAllFlight(@RequestParam("departureLocation") String departureLocation,@RequestParam("arrivalLocation") String arrivalLocation
			,@RequestParam("flightDate") Date flightDate,@RequestParam("flightClass") String flightClass
			,@RequestParam("outputPreference") String outputPreference,HttpServletRequest request)
	{		
		request.setAttribute("flights",flightService.showAllFlight(departureLocation,arrivalLocation,flightDate,flightClass,outputPreference) );
		request.setAttribute("mode", "All_Flights");
		
		return "AvailableFlightSearch.jsp";		
		
	}

}
