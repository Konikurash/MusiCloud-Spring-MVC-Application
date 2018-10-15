package com.app.business;

import java.util.ArrayList;
import java.util.List;

import com.app.model.SongModel;
import com.app.model.UserModel;

public class UsersBusinessService implements UsersBusinessInterface {

	private List<UserModel> users = new ArrayList<UserModel>();
	
	@Override
	public void init() {
		System.out.println("Hello from UsersBusinessService.init");

	}

	@Override
	public void destroy() {
		System.out.println("Hello from UsersBusinessService.destroy");

	}

	@Override
	public boolean addUser(UserModel user) {
		if(user.equals(null))
		{
			System.out.println("Error in UsersBusinessService.addUser");
			return false;
		}
		users.add(user);
		return true;
	}

	@Override
	public boolean removeUser(int id) {
		UserModel u = getUserById(id);
		users.remove(u);
		return true;
	}

	@Override
	public UserModel getUserById(int id) {
		for(UserModel u : users)
		{
			if(u.getId() == id)
			{
				return u;
			}
		}
		System.out.println("User does not exist");
		return null;
	}

	@Override
	public List<UserModel> getUserList() {
		return users;
	}

}
