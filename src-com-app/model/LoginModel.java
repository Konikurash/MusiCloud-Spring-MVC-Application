package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/*
 *  LoginModel used with the login form and all login actions in the UserController
 *  Used for data validation and for containing only the required data for logging in
 *  May also use first/last name to login in the future.
 * 
 *  Created by William Bierer & Brendan Brooks.
 */

public class LoginModel {
	
	//create email string and set its size from 3-50 chars
	@NotNull(message="An E-Mail Address in required.")
	@Size(min=3, max=50, message="E-Mail Address must be between 3 and 50 characters")
	private String email;
	
	//create password string and set its size from 6-25 chars
	@NotNull(message="Password is required.")
	@Size(min=6, max=25, message="Password must be between 6 and 25 characters")
	private String password;
	//default constructor
	public LoginModel()
	{
		this.email = "";
		this.password = "";

	}
	//non-default constructor
	public LoginModel(String email, String password) {
		this.email = email;
		this.password = password;
	}
	//create getters/setters for all vars
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
