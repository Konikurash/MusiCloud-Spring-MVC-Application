package com.app.business.interfaces;

import java.util.List;

import com.app.model.ChangePasswordModel;
import com.app.model.UserModel;

public interface UsersBusinessInterface {
	public boolean addUser(UserModel user);
	public boolean removeUser(int id);
	public boolean updateUser(UserModel user);
	public boolean updatePassword(ChangePasswordModel model);
	public boolean checkIfUserExists(UserModel user);
	public UserModel getUserById(int id);
	public UserModel loginUserWithModel(UserModel model);
}
