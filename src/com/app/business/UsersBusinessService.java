package com.app.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.business.interfaces.UsersBusinessInterface;
import com.app.data.interfaces.UserDataAccessInterface;
import com.app.model.ChangePasswordModel;
import com.app.model.UserModel;

/**
 * Business service for songs.  utilizes userDataService
 *
 * @author William Bierer
 * @author Brendan Brooks
 * @version .05
 */
public class UsersBusinessService implements UsersBusinessInterface {

	//create UserDateService for use with business service
	private UserDataAccessInterface service;

	/**
	 * add new user method
	 * 
	 * @param UserModel user
	 * @return boolean value
	 */
	@Override
	public boolean addUser(UserModel user) {
		//check if user is null
		if(user.equals(null))
		{
			System.out.println("Error in UsersBusinessService.addUser: User is null");
			return false;
		}
		
		//use create method from data service and return bool
		return service.create(user);
	}
	
	/**
	 * update existing user method
	 * 
	 * @param UserModel user
	 * @return boolean value
	 */
	@Override
	public boolean updateUser(UserModel user) {
		//use update method from data service
		return service.update(user);
	}

	/**
	 * update existing user password method
	 * 
	 * @param ChangePasswordModel model
	 * @return boolean value
	 */
	@Override
	public boolean updatePassword(ChangePasswordModel model) {
		//use update password method from data service
		return service.updatePassword(model);
	}
	
	/**
	 * method used for logging user into the application
	 * 
	 * @param UserModel model
	 * @return UserModel user
	 */
	@Override
	public UserModel loginUserWithModel(UserModel model) {
		UserModel user = service.findByObject(model);
		//System.out.println(model.getEmail() + " | " + model.getPassword());
		return user;
	}

	/**
	 * Remove user method
	 * 
	 * @param int id
	 * @return boolean value
	 */
	@Override
	public boolean removeUser(int id) {

		//use delete method from data service
		return service.delete(id);
	}

	@Override
	public UserModel getUserById(int id) {
		return null;
	}
	
	/**
	 * Autowired method for setting userDataService to UserDataAccessInterface
	 * 
	 * @param UserDataAccessInterface service
	 */
	@Autowired
	public void setUserDataService(UserDataAccessInterface service)
	{
		this.service = service;
	}

	/**
	 * method used for verifying if user exists.  Used for checking if email already exists
	 * 
	 * @param UserModel model
	 * @return boolean value
	 */
	@Override
	public boolean checkIfUserExists(UserModel user) {
		//use findByEmail method from dataService
		user = service.findByEmail(user.getEmail());
		
		//if id == -1 user doesn't exist and return false
		if(user.getId() == -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
