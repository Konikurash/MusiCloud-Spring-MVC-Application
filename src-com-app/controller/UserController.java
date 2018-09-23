package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private List<User> users = new ArrayList<User>();
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public ModelAndView displayReg()
	{
		return new ModelAndView("register", "user", new User());
	}

	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView displayForm() 
	{
		users.add(new User("William", "Bierer", "Will@gmail.com", "password"));
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(path="/adduser", method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user")User user) 
	{
		users.add(user);
		return new ModelAndView("login", "users", users);
	}
	
	@RequestMapping(path="/verify", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user")User user)
	{
		for(User u : users)
		{
			if(user.getEmail().equals(u.getEmail())  && user.getPassword().equals(u.getPassword()))
			{
				return new ModelAndView("main", "user", user);
			}
		}
		
		return new ModelAndView("login", "user", user);
	}
}
