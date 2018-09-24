package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 *  User object used with the registration form and all register actions in the UserController
 *  Used for data validation and for containing all the data needed for registering an account
 *  id will be used when we hook up a MySQL DB  TODO Hook up MySQL DB
 * 
 *  Created by William Bierer & Brendan Brooks.
 */


public class User {
	//create id for use with MySQL DB
	private int id;
	//create firstName string and set its size from 1-30 chars
	@NotNull(message="First Name is required.")
	@Size(min=1, max=30, message="First name must be between 1 and 30 characters")
	private String firstName;
	//create lastName string and set its size from 1-30 chars
	@NotNull(message="Last Name is required.")
	@Size(min=1, max=30, message="Last Name must be between 1 and 30 characters")
	private String lastName;
	//create email string and set its size from 3-50 chars
	@NotNull(message="An E-Mail Address in required.")
	@Size(min=3, max=50, message="E-Mail Address must be between 3 and 50 characters")
	private String email;
	//create password string and set its size from 6-25 chars
	@NotNull(message="Password is required.")
	@Size(min=6, max=25, message="Password must be between 6 and 25 characters")
	private String password;
	//create password confirmation string and set its size from 6-25 chars
	@NotNull(message="You must confirm your passowrd")
	@Size(min=6, max=25, message="Password Confirmation must be between 6 and 25 characters")
	private String passwordConfirmation; //For registration only
	//default constructor
	public User()
	{
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.passwordConfirmation = "";

	}
	//non-default constructor
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	//create getters/setters for all vars
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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
	
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
}
