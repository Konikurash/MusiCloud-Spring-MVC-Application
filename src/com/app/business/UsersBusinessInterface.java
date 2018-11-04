package com.app.business;

import java.util.List;

import com.app.model.UserModel;

public interface UsersBusinessInterface {
	public boolean addUser(UserModel user);
	public boolean removeUser(int id);
	public UserModel getUserById(int id);
	public UserModel loginUserWithModel(UserModel model);
}
