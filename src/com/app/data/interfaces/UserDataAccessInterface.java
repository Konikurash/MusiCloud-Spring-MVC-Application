package com.app.data.interfaces;

import com.app.data.interfaces.DataAccessInterface;
import com.app.model.ChangePasswordModel;
import com.app.model.UserModel;

public interface UserDataAccessInterface extends DataAccessInterface<UserModel> {
	public UserModel findByEmail(String email);
	public boolean updatePassword(ChangePasswordModel model);
}
