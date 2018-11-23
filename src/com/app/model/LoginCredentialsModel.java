package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *  LoginModel used with the login form and all login actions in the UserController
 *  Used for data validation and for containing only the required data for logging in
 * 
 *  @author William Bierer
 *  @author Brendan Brooks
 *  @version 0.5
 */
public class LoginCredentialsModel {
	
	//create email string and set its size from 3-50 chars
	@NotNull(message="An E-Mail Address in required.")
	@Size(min=3, max=50, message="E-Mail Address must be between 3 and 50 characters")
	private String email;
	
	//create password string and set its size from 6-25 chars
	@NotNull(message="Password is required.")
	@Size(min=6, max=25, message="Password must be between 6 and 25 characters")
	private String password;

	/**
	 * Default constructor method
	 *
	 */
	public LoginCredentialsModel()
	{
		this.email = "";
		this.password = "";

	}

	/**
	 * Non default constructor method
	 *
	 * @param  email String used with login form
	 * @param  password String used with login form
	 */
	public LoginCredentialsModel(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/**
	 * Getter method for email
	 * 
	 *
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email
	 * 
	 *
	 * @param String email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Getter method for password
	 * 
	 *
	 * @return String password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password
	 * 
	 *
	 * @param String password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
