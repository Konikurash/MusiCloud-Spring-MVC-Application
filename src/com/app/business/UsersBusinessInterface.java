package com.app.business;

import java.util.List;

import com.app.model.ChangePasswordModel;
import com.app.model.UserModel;

public interface UsersBusinessInterface {
	public boolean addUser(UserModel user);
	public boolean removeUser(int id);
	public boolean updateUser(UserModel user);
	public boolean updatePassword(ChangePasswordModel model);
	public UserModel getUserById(int id);
	public UserModel loginUserWithModel(UserModel model);

}
