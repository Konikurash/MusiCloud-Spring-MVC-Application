package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* 
 * User model for logging in and registering to the site.
 * 
 * 
 * */

public class User {
	
	private int id;
	
	@NotNull(message="First Name is required.")
	@Size(min=1, max=30, message="First name must be between 1 and 30 characters")
	private String firstName;
	
	@NotNull(message="Last Name is required.")
	@Size(min=1, max=30, message="Last Name must be between 1 and 30 characters")
	private String lastName;
	
	@NotNull(message="An E-Mail Address in required.")
	@Size(min=3, max=50, message="E-Mail Address must be between 3 and 50 characters")
	private String email;
	
	@NotNull(message="Password is required.")
	@Size(min=6, max=25, message="Password must be between 6 and 25 characters")
	private String password;
	
	@NotNull(message="You must confirm your passowrd")
	@Size(min=6, max=25, message="Password must be between 6 and 25 characters.")
	private String passwordConfirmation; //For registration only
	
	public User()
	{
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.passwordConfirmation = "";

	}

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

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
