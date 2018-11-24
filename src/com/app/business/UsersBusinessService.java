package com.app.business;

import org.springframework.beans.factory.annotation.Autowired;

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

	private UserDataAccessInterface service;

	/**
	 * add user method
	 * 
	 * @param UserModel user
	 * @return boolean value
	 */
	@Override
	public boolean addUser(UserModel user) {
		if(user.equals(null))
		{
			System.out.println("Error in UsersBusinessService.addUser: User is null");
			return false;
		}
		
		return service.create(user);
	}
	
	/**
	 * update user method
	 * 
	 * @param UserModel user
	 * @return boolean value
	 */
	@Override
	public boolean updateUser(UserModel user) {
		// TODO Auto-generated method stub
		return service.update(user);
	}

	/**
	 * update user password method
	 * 
	 * @param ChangePasswordModel model
	 * @return boolean value
	 */
	@Override
	public boolean updatePassword(ChangePasswordModel model) {
		// TODO Auto-generated method stub
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

	@Override
	public boolean checkIfUserExists(UserModel user) {
		user = service.findByEmail(user.getEmail());
		
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
