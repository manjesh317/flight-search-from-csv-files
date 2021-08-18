package com.nagarro.FlightSearchManagement;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nagarro.FlightSearchManagement.service.FlightService;

@SpringBootApplication
public class FlightSearchManagementApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context= SpringApplication.run(FlightSearchManagementApplication.class, args);
		FlightService flightService=context.getBean(FlightService.class);
		flightService.readFilesOfFolder();
		
	}

}
