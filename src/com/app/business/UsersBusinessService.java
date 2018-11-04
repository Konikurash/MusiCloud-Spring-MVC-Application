package com.app.business;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.UserDataService;
import com.app.data.interfaces.UserDataAccessInterface;
=======
>>>>>>> origin/master
import com.app.model.SongModel;
import com.app.model.UserModel;

public class UsersBusinessService implements UsersBusinessInterface {

<<<<<<< HEAD
	private UserDataAccessInterface service;
=======
	private List<UserModel> users = new ArrayList<UserModel>();
	
	@Override
	public void init() {
		System.out.println("Hello from UsersBusinessService.init");

	}

	@Override
	public void destroy() {
		System.out.println("Hello from UsersBusinessService.destroy");

	}
>>>>>>> origin/master

	@Override
	public boolean addUser(UserModel user) {
		if(user.equals(null))
		{
<<<<<<< HEAD
			System.out.println("Error in UsersBusinessService.addUser: User is null");
			return false;
		}
		
		return service.create(user);
	}
	
	@Override
	public UserModel loginUserWithModel(UserModel model) {
		UserModel user = service.findByObject(model);
		return user;
=======
			System.out.println("Error in UsersBusinessService.addUser");
			return false;
		}
		users.add(user);
		return true;
>>>>>>> origin/master
	}

	@Override
	public boolean removeUser(int id) {
		UserModel u = getUserById(id);
<<<<<<< HEAD
=======
		users.remove(u);
>>>>>>> origin/master
		return true;
	}

	@Override
	public UserModel getUserById(int id) {
<<<<<<< HEAD
		return null;
	}
	
	@Autowired
	public void setUserDataService(UserDataAccessInterface service)
	{
		this.service = service;
=======
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
>>>>>>> origin/master
	}

}
