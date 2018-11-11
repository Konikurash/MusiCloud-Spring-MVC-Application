package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	public ChangePasswordModel(String newPassword, String newPasswordConfirmation, int id) {
		super();
		this.newPassword = newPassword;
		this.newPasswordConfirmation = newPasswordConfirmation;
		this.id = id;
	}
	
	public ChangePasswordModel()
	{
		newPassword = "";
		newPasswordConfirmation = "";
		this.id = -1;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirmation() {
		return newPasswordConfirmation;
	}

	public void setNewPasswordConfirmation(String newPasswordConfirmation) {
		this.newPasswordConfirmation = newPasswordConfirmation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
