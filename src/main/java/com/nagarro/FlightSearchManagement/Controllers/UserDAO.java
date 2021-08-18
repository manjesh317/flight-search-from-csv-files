package com.nagarro.FlightSearchManagement.Controllers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.FlightSearchManagement.model.User;

public interface UserDAO extends JpaRepository<User, Integer>{

}