package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import com.app.model.UserModel;
import com.app.business.UsersBusinessInterface;
import com.app.model.LoginCredentialsModel;

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
//@RequestMapping("/user")
public class UserController {
	
	//call UsersBusinessService
	UsersBusinessInterface userService;
	
	@Autowired
	private HttpSession httpSession;
	
	//Create an ArrayList of users to use temporarily until we hook up a MySQL DB
//	private List<UserModel> users = new ArrayList<UserModel>();
	
	//Create method for linking to login/register view
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView displayLog()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", new LoginCredentialsModel());
		mv.addObject("user", new UserModel());
		mv.setViewName("loginReg");
		
		return mv;
	}
	@RequestMapping(path="/loginUser", method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("login")LoginCredentialsModel login, BindingResult resultLogin, @Valid @ModelAttribute("user")UserModel user, BindingResult resultuser)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new UserModel());
		
		if(resultLogin.hasErrors())
		{
			mv.addObject("login", login);
			mv.setViewName("loginReg");
			return mv;
		}
		
		UserModel loggedIn = userService.loginUserWithModel(new UserModel("", "", login.getEmail(), login.getPassword()));
		if(loggedIn.getId() != -1)
		{
			httpSession.setAttribute("user", loggedIn);
			//if so, redirect to main view
			mv.setViewName("redirect: library/main");
			return mv;
		}
		
		//if not, refresh the login view
		mv.addObject("login", new LoginCredentialsModel());
		mv.setViewName("loginReg");
		return mv;
	}
	@RequestMapping(path="/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user")UserModel user, BindingResult resultUser, @Valid @ModelAttribute("login")LoginCredentialsModel login, BindingResult resultLogin)
	{
		ModelAndView mv = new ModelAndView();
		
		if(resultUser.hasErrors())
		{
			mv.addObject("user", user);
			mv.addObject("login", new LoginCredentialsModel());
			mv.setViewName("loginReg");
			return mv;
		}
		
		//Check if password field is equal to password confirmation field
		if(user.getPassword().equals(user.getPasswordConfirmation()))
		{
			//if so, add user to the arraylist and direct to the login view
			userService.addUser(user);
			login.setEmail(user.getEmail());
			mv.addObject("user", user);
			mv.addObject("login", login);
			mv.setViewName("loginReg");
			return mv;
		}
		else
		{
			//if not, display error showing passwords do not match and refresh the register view
			resultUser.rejectValue("passwordConfirmation", "error.user", "Passwords do not match");
			mv.addObject("user", user);
			mv.addObject("login", login);
			mv.setViewName("loginReg");
			return mv;
		}
	}
	
	@Autowired
	public void setUsersService(UsersBusinessInterface service)
	{
		this.userService = service;
	}
	
}
