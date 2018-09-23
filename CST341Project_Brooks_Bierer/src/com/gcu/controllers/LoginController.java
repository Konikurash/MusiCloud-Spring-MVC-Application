package com.gcu.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.models.User;
@Controller
//@RequestMapping("/login")
public class LoginController {

	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView displayForm() 
	{
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(path="/addUser", method=RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user")User user, BindingResult result) 
	{
		if (result.hasErrors())
		{
			return new ModelAndView("addUser", "user", user);
		}
		List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(new User());
		return new ModelAndView("displayUsers", "users", users);
	}
}
