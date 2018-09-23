package com.gcu.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	@NotNull(message="First Name cannot be null")
	@Size(min=2, max=30, message="First Name must be between 2 and 30 characters")
	public String firstName;
	
	@NotNull(message="Last Name cannot be null")
	@Size(min=2, max=30, message="Last Name must be between 2 and 30 characters")
	public String lastName;
	
	@NotNull(message="Email cannot be null")
	@Size(min=4, max=70, message="Email must be between 4 and 70 characters.")
	public String email;
	
	@NotNull(message="Password cannot be null")
	@Size(min=4, max=70, message="Password must be between 4 and 50 characters.")
	public String password;
	
	@NotNull(message="Password confirmation cannot be null")
	@Size(min=4, max=70, message="Password must be between 4 and 50 characters.")
	public String passwordConfirmation; //For registration only

	public User() {
		firstName = "";
		lastName = "";
		email = "";
		password = "";
		passwordConfirmation = "";
	}
	
	public User(String firstName, String lastName, String email, String password, String passwordConfirmation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
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
