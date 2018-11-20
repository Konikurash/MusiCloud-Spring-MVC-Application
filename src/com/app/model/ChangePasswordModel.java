package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model used with the Change Password form in the editUser view
 *
 * @author William Bierer
 * @author Brendan Brooks
 * @version .05
 */
public class ChangePasswordModel {
	
	private int id;
	
	//create password string and set its size from 6-25 chars
	@NotNull(message="Password is required.")
	@Size(min=6, max=25, message="Password must be between 6 and 25 characters")
	private String newPassword;
	
	//create password string and set its size from 6-25 chars
	@NotNull(message="Password is required.")
	@Size(min=6, max=25, message="Password must be between 6 and 25 characters")
	private String newPasswordConfirmation;
	
	/**
	 * Non default constructor method
	 *
	 * @param  new password for new password form
	 * @param  new password confirmation for new password form
	 * @param  id that represents the user ID
	 */
	public ChangePasswordModel(String newPassword, String newPasswordConfirmation, int id) {
		super();
		this.newPassword = newPassword;
		this.newPasswordConfirmation = newPasswordConfirmation;
		this.id = id;
	}
	
	/**
	 * default constructor method
	 *
	 * @param  new password for new password form
	 * @param  new password confirmation for new password form
	 * @param  id that represents the user ID
	 */
	public ChangePasswordModel()
	{
		newPassword = "";
		newPasswordConfirmation = "";
		this.id = -1;
	}
	
	/**
	 * Getter method for newPassword
	 * 
	 *
	 * @return String newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	
	/**
	 * Setter Method for newPassword
	 *
	 * 
	 * @param String newPassword
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	/**
	 * Getter method for newPasswordConfirmation
	 * 
	 *
	 * @return String newPasswordConfirmation
	 */
	public String getNewPasswordConfirmation() {
		return newPasswordConfirmation;
	}

	/**
	 * Setter Method for newPasswordConfirmation
	 *
	 * 
	 * @param String newPasswordConfirmation
	 */
	public void setNewPasswordConfirmation(String newPasswordConfirmation) {
		this.newPasswordConfirmation = newPasswordConfirmation;
	}

	/**
	 * Getter Method for id
	 *
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter Method for id
	 *
	 * 
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}
}
