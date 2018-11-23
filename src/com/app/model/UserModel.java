package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *  User object used with the registration form and all register actions in the UserController
 *  User persists to the session after successful login
 * 
 *  @author William Bierer
 *  @author Brendan Brooks
 */
public class UserModel {
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
	
	/**
	 * Default constructor method
	 * 
	 * 
	 */
	public UserModel()
	{
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.password = "";
		this.passwordConfirmation = "";
		this.id = -1;

	}

	/**
	 * Non default constructor method
	 * 
	 * @param String firstName : represents first name of user
	 * @param String lastName : represents last name of user
	 * @param String email : represents email
	 * @param String password : represents password of the user
	 */
	public UserModel(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.id = -1;
	}
	
	/**
	 * Default constructor method
	 * 
	 * 
	 */
	public UserModel(int id, String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.id = id;
	}

	/**
	 * Getter method for id
	 * 
	 *
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id
	 * 
	 *
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter method for firstName
	 * 
	 *
	 * @return String firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for firstName
	 * 
	 *
	 * @param String firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter method for lastName
	 * 
	 *
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method for lastName
	 * 
	 *
	 * @param String lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	/**
	 * Getter method for passwordConfirmation
	 * 
	 *
	 * @return String passwordConfirmation
	 */
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	/**
	 * Setter method for passwordConfirmation
	 * 
	 *
	 * @param String passwordConfirmation
	 */
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
}