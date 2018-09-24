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
import com.app.model.LoginModel;

/*
 * Controller for handling login and registration modules.
 * Currently reads/writes to an ArrayList of Users to login and register
 * If user logs in successfully, User goes to the main view.
 * 
 * TODO Hook up MySQL DB and create a DAO to use with this controller instead of a simple ArrayList
 * 
 * Created by William Bierer & Brendan Brooks.
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	//Create an ArrayList of users to use temporarily until we hook up a MySQL DB
	private List<User> users = new ArrayList<User>();
	
	//Create Method for linking to register view
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public ModelAndView displayRegister()
	{
		//return register view
		return new ModelAndView("register", "user", new User());
	}
	
	//create method for linking to login view
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView displayLogin() 
	{
		//add user to list for testing
		users.add(new User("William", "Bierer", "Will@gmail.com", "password"));
		//return login view
		return new ModelAndView("login", "login", new LoginModel());
	}
	
	//create registration action for use with the register form.  Use the LoginModel object as the model
	@RequestMapping(path="/adduser", method=RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user")User user, BindingResult result) 
	{
		//validate all fields on the form
		if (result.hasErrors())
		{
			return new ModelAndView("register", "user", user);
		}
		
		//Check if password field is equal to password confirmation field
		if(user.getPassword().equals(user.getPasswordConfirmation()))
		{
			//if so, add user to the arraylist and direct to the login view
			users.add(user);
			return new ModelAndView("login", "login", new LoginModel());
		}
		else
		{
			//if not, display error showing passwords do not match and refresh the register view
			result.rejectValue("passwordConfirmation", "error.user", "Passwords do not match");
			return new ModelAndView("register", "user", user);
		}
	}
	
	//create login action for use with the login form.  use the User object as the model
	@RequestMapping(path="/verify", method=RequestMethod.POST)
	public ModelAndView login(@Valid @ModelAttribute("login")LoginModel login, BindingResult result)
	{
		//validate all fields on the form
		if (result.hasErrors())
		{
			return new ModelAndView("login", "login", login);
		}
		//run a foreach loop to read all users in the arraylist
		for(User u : users)
		{
			//check if the email and password entered is equal to any of the users in the list
			if(login.getEmail().equals(u.getEmail())  && login.getPassword().equals(u.getPassword()))
			{
				//if so, redirect to main view
				return new ModelAndView("main", "login", login);
			}
		}
		//if not, refresh the login view
		return new ModelAndView("login", "login", login);
	}
}
