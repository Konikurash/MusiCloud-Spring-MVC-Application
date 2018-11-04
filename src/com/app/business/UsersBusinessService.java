package com.app.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.UserDataService;
import com.app.data.interfaces.UserDataAccessInterface;
import com.app.model.SongModel;
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
		return user;
	}

	@Override
	public boolean removeUser(int id) {
		UserModel u = getUserById(id);
		return true;
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
