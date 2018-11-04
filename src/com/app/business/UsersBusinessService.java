package com.app.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.interfaces.UserDataAccessInterface;

import com.app.model.UserModel;

public class UsersBusinessService implements UsersBusinessInterface {

	private UserDataAccessInterface service;

	@Override
	public boolean addUser(UserModel user) {
		if(user.equals(null))
		{
			System.out.println("Error in UsersBusinessService.addUser: User is null");
			return false;
		}
		
		return service.create(user);
	}
	
	@Override
	public UserModel loginUserWithModel(UserModel model) {
		UserModel user = service.findByObject(model);
		System.out.println(model.getEmail() + " | " + model.getPassword());
		return user;
	}

	@Override
	public boolean removeUser(int id) {

		return false;
	}

	@Override
	public UserModel getUserById(int id) {
		return null;
	}
	
	@Autowired
	public void setUserDataService(UserDataAccessInterface service)
	{
		this.service = service;
	}

}
