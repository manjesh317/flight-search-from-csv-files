package com.nagarro.FlightSearchManagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.FlightSearchManagement.model.User;

@Controller
public class LoginController {
	@Autowired
	UserDAO dao;
	
	@RequestMapping("/LoginValidator")
	public ModelAndView getUser(@RequestParam("id") int aid,@RequestParam("name") String name,@RequestParam("password") String password)
	{
		ModelAndView mv=new ModelAndView("SignUp.jsp");
		if(dao.findById(aid)!=null)
		{
			User user=dao.findById(aid).orElse(new User());
			mv.addObject("sessionData", user);
			if(user.getName().equals(name)&&user.getPassword().equals(password)) {
				mv.addObject("sessionData", user);
				mv.setViewName("FlightSearch.jsp");				
			}
			else {
				mv.setViewName("Login.jsp");
			}
		}
		else
			mv.setViewName("SignUp.jsp");
		return mv;
	}
}
