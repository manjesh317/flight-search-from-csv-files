package com.nagarro.FlightSearchManagement.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.FlightSearchManagement.model.Flight;

@Repository
public interface FlightDTO extends JpaRepository<Flight, Integer>{

}
