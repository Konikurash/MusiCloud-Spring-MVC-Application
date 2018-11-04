package com.app.business;

import java.util.List;

import com.app.model.UserModel;

public interface UsersBusinessInterface {
<<<<<<< HEAD
	public boolean addUser(UserModel user);
	public boolean removeUser(int id);
	public UserModel getUserById(int id);
	public UserModel loginUserWithModel(UserModel model);
=======
	public void init();
	public void destroy();
	public boolean addUser(UserModel user);
	public boolean removeUser(int id);
	public UserModel getUserById(int id);
	public List<UserModel> getUserList();
>>>>>>> origin/master
}
