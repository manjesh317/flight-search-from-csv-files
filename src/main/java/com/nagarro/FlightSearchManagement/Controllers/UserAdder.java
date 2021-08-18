package com.nagarro.FlightSearchManagement.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.FlightSearchManagement.model.User;

@Controller
public class UserAdder {
	@Autowired
	UserDAO dao;
	
	@RequestMapping("/")
	public String addUser()
	{
		return "SignUp.html";
	}
	
	@GetMapping("/addUser")
	public String addUser(User user)
	{
		dao.save(user);
		return "SignUp.html";
	}

	@DeleteMapping("/user/{aid}")
	@ResponseBody
	public String deleteUser(@PathVariable int aid)
	{
		User user=dao.getOne(aid);
		dao.delete(user);
		return "deleted";
	}
	@GetMapping(path = "/users" )
	@ResponseBody
	public List<User> getUsers()
	{		
		return dao.findAll();		
	}
	@PostMapping(path = "/users" , consumes = {"application/json"})
	@ResponseBody
	public User getUser(@RequestBody User user)
	{		
		dao.save(user);
		return user;		
	}
	@PutMapping(path = "/users" , consumes = {"application/json"})
	@ResponseBody
	public User saveOrUpdateUser(@RequestBody User user)
	{		
		dao.save(user);
		return user;		
	}
	@RequestMapping("/user/{aid}")
	@ResponseBody
	public Optional<User> getUser(@PathVariable("aid") int aid)
	{		
		return dao.findById(aid);		
	}

}