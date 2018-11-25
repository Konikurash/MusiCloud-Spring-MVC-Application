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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import com.app.model.UserModel;
import com.app.business.UsersBusinessInterface;
import com.app.model.ChangePasswordModel;
import com.app.model.LoginCredentialsModel;

/**
 * Controller for handling login and registration modules.
 * Reads/writes from MySQL DB
 * 
 * @author William Bierer
 * @author Brendan Brooks
 */

@Controller
public class UserController {
	
	//call UsersBusinessService
	private UsersBusinessInterface userService;

	@Autowired
	private HttpSession httpSession;
	
	/**
	 * Directs to the login/registration view
	 * Maps to / or /login
	 * 
	 * @return ModelAndView mv
	 */
	//Create method for linking to login/register view
	@RequestMapping(path= { "/", "/login" }, method=RequestMethod.GET)
	public ModelAndView displayLog()
	{
		ModelAndView mv = new ModelAndView();
		
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		
		if(sessionUser != null)
		{
			mv.setViewName("redirect: library/main");
			return mv;
		}
		
		displayLoginForm(mv);
		mv.addObject("login", new LoginCredentialsModel());
		mv.addObject("user", new UserModel());
		mv.setViewName("loginReg");
		
		return mv;
	}
	
	/**
	 * Logs a user in and directs to the main view if successful
	 * Maps to /loginUser
	 * 
	 * @param UserModel user
	 * @param BindingResult resultUser
	 * @param LoginCredentialsModel login
	 * @param BindingResult resultLogin
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/loginUser", method=RequestMethod.POST)
	public ModelAndView loginUser(@Valid @ModelAttribute("login")LoginCredentialsModel login, BindingResult resultLogin, @Valid @ModelAttribute("user")UserModel user, BindingResult resultuser)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new UserModel());
		
		if(resultLogin.hasErrors())
		{
			displayLoginForm(mv);
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
		mv.setViewName("redirect:/");
		return mv;
	}
	
	/**
	 * Registers a new user and uses userService to add user to the database
	 * Maps to /registerUser
	 * 
	 * @param UserModel user
	 * @param BindingResult resultUser
	 * @param LoginCredentialsModel login
	 * @param BindingResult resultLogin
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/registerUser", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user")UserModel user, BindingResult resultUser, @Valid @ModelAttribute("login")LoginCredentialsModel login, BindingResult resultLogin, RedirectAttributes redir)
	{
		ModelAndView mv = new ModelAndView();
		
		//check if the form has errors
		if(resultUser.hasErrors())
		{
			displayRegisterForm(mv);
			mv.addObject("user", user);
			mv.addObject("login", new LoginCredentialsModel());
			mv.setViewName("loginReg");
			return mv;
		}
		
		//check if the user already exists
		if(userService.checkIfUserExists(user))
		{
			System.out.println("User Already Exists");
			resultUser.rejectValue("userExists", "error.user", "The Email of the account you are trying to create already exists, please use a different Email Address.");
			user.setEmail("");
			displayRegisterForm(mv);
			mv.addObject("user", user);
			mv.addObject("login", new LoginCredentialsModel());
			mv.setViewName("loginReg");
			return mv;
		}
		else
		{
			
			//Check if password field is equal to password confirmation field
			if(user.getPassword().equals(user.getPasswordConfirmation()))
			{
				//if so, add user to the arraylist and direct to the login view
				userService.addUser(user);
				login.setEmail(user.getEmail());
				mv.setViewName("redirect:/");
				return mv;
			}
			else
			{
				//if not, display error showing passwords do not match and refresh the register view
				resultUser.rejectValue("passwordConfirmation", "error.user", "Passwords do not match");
				displayRegisterForm(mv);
				mv.addObject("user", user);
				mv.addObject("login", login);
				mv.setViewName("loginReg");
				return mv;
			}
		}
	}
	
	/**
	 * Directs to the settings view where the user can update and delete his account
	 * 
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/settings", method=RequestMethod.GET)
	public ModelAndView showEditPage()
	{
		ModelAndView mv = new ModelAndView();
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		
		if(sessionUser == null)
		{
			return new ModelAndView("redirect: login");
		}
		
		mv.addObject("user", sessionUser);
		mv.addObject("passwordModel", new ChangePasswordModel());
		mv.setViewName("editUser");
		return mv;
		
	}
	
	/**
	 * Updates an existing user and uses userService to update the user in the db
	 * Maps to /updateUser
	 * 
	 * @param UserModel user
	 * @param BindingResult resultUser
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/updateUser", method=RequestMethod.POST)
	public ModelAndView updateUser(@Valid @ModelAttribute("user")UserModel user, BindingResult resultUser)
	{
		ModelAndView mv = new ModelAndView();
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		
		if(sessionUser == null)
		{
			mv.setViewName("redirect: login");
			return mv;
		}
		
		user.setId(sessionUser.getId());
		if(resultUser.hasFieldErrors("firstName") || resultUser.hasFieldErrors("lastName") || resultUser.hasFieldErrors("email"))
		{
			mv.addObject("passwordModel", new ChangePasswordModel());
			mv.addObject("user", user);
			mv.setViewName("editUser");
			return mv;
		}
		
		if(userService.updateUser(user))
		{
			httpSession.setAttribute("user", user);
			mv.setViewName("redirect: settings");
			return mv;
		}
		
		mv.addObject("passwordModel", new ChangePasswordModel());
		mv.addObject("user", sessionUser);
		mv.setViewName("editUser");
		return mv;
	}
	
	/**
	 * Updates the password of an existing user and uses userService to update the user's password in the db
	 * Maps to /updateUser
	 * 
	 * @param ChangePasswordModel passwordModel
	 * @param BindingResult resultUser
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/updatePassword", method=RequestMethod.POST)
	public ModelAndView updatePassword(@Valid @ModelAttribute("passwordModel")ChangePasswordModel passwordModel, BindingResult resultUser)
	{
		ModelAndView mv = new ModelAndView();
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		
		if(sessionUser == null)
		{
			mv.setViewName("redirect: login");
			return mv;
		}
		
		passwordModel.setId(sessionUser.getId());
		
		if(resultUser.hasFieldErrors("newPassword") || resultUser.hasFieldErrors("newPasswordConfirmation") || !passwordModel.getNewPassword().equals(passwordModel.getNewPasswordConfirmation()))
		{
			mv.addObject("user", sessionUser);
			mv.addObject("passwordModel", new ChangePasswordModel());
			mv.setViewName("editUser");
			return mv;
		}
		
		if(userService.updatePassword(passwordModel))
		{
			mv.setViewName("redirect: settings");
			return mv;
		}
		
		mv.addObject("user", sessionUser);
		mv.addObject("passwordModel", new ChangePasswordModel());
		mv.setViewName("editUser");
		return mv;
	}
	
	/**
	 * removes the user from the session and directs the user back to the login/registration form
	 * Maps to /logout
	 * 
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public ModelAndView logoutUser()
	{
		httpSession.removeAttribute("user");
		
		return new ModelAndView("redirect: login");
	}
	
	/**
	 * Deletes the current user in the session and removes the user from the db
	 * Maps to /deleteAcocunt
	 * 
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/deleteAccount", method=RequestMethod.GET)
	public ModelAndView deleteUser()
	{
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		
		if(sessionUser == null)
		{
			mv.setViewName("redirect: login");
			return mv;
		}
		
		userService.removeUser(sessionUser.getId());
		httpSession.removeAttribute("user");
		
		return new ModelAndView("redirect: login");
	}
	
	/**
	 * Autowired Method that sets the user service
	 * 
	 * @param UserBusinessInterface service
	 */
	@Autowired
	public void setUsersService(UsersBusinessInterface service)
	{
		this.userService = service;
	}
	
	/**
	 * Causes the registration form to initially display when loading login/registration view
	 * 
	 * @param ModelAndView mv
	 */
	private void displayRegisterForm(ModelAndView mv)
	{
		mv.addObject("logStyle", new String("display: none;"));
		mv.addObject("regStyle", new String(""));
		mv.addObject("head", new String("Register"));
	}
	
	/**
	 * Causes the login form to initially display when loading login/registration view
	 * 
	 * @param ModelAndView mv
	 */
	private void displayLoginForm(ModelAndView mv)
	{
		mv.addObject("logStyle", new String(""));
		mv.addObject("regStyle", new String("display: none;"));
		mv.addObject("head", new String("Login"));
	}
	
}
