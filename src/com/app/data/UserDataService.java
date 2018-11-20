package com.app.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.app.data.interfaces.UserDataAccessInterface;
import com.app.model.ChangePasswordModel;
import com.app.model.UserModel;

/**
 * Data service for User.  Reads and writes to MySQL DB
 *
 * @author William Bierer
 * @author Brendan Brooks
 * @version .05
 */
public class UserDataService implements UserDataAccessInterface {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * Create user method
	 * 
	 * @param UserModel t
	 * @return boolean value
	 */
	@Override
	public boolean create(UserModel t) {
		String sql = "INSERT INTO users(firstName, lastName, email, password) VALUES(?, ?, ?, ?)";
		try
		{
			int rows = jdbcTemplateObject.update(sql, t.getFirstName(), t.getLastName(), t.getEmail(), t.getPassword());
			
			return rows == 1 ? true : false;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Update user method
	 * 
	 * @param UserModel t
	 * @return boolean value
	 */
	@Override
	public boolean update(UserModel t) {
		String sql = "UPDATE users SET firstName=?, lastName=?, email=? WHERE id=?";
		try
		{
			jdbcTemplateObject.update(sql, t.getFirstName(), t.getLastName(), t.getEmail(), t.getId());
			
			return true;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Delete user method
	 * 
	 * @param UserModel t
	 * @return boolean value
	 */
	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM users WHERE id=?";
		try
		{
			int rows = jdbcTemplateObject.update(sql, id);
			
			return rows == 1 ? true : false;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Finds a user based on a model, used for logging in
	 * 
	 * @param UserModel t
	 * @return UserModel
	 */
	@Override
	public UserModel findByObject(UserModel t) {
		String sql = "SELECT * FROM users WHERE email=? AND password=?";
		UserModel user = new UserModel();
		
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, t.getEmail(), t.getPassword());
			if (srs.next())
			{
				user = new UserModel(srs.getInt("id"), srs.getString("firstName"), srs.getString("lastName"), srs.getString("email"), "");
				return user;
			}
			else
			{
				System.out.println("Could not find that user");
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return user;
		}
	}

	@Override
	public UserModel findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Update password method
	 * 
	 * @param ChangePasswordModel model
	 * @return boolean value
	 */
	@Override
	public boolean updatePassword(ChangePasswordModel model) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users SET password=? WHERE id=?";
		try
		{
			int rows = jdbcTemplateObject.update(sql, model.getNewPassword(), model.getId());
			
			return rows == 1 ? true : false;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * Audiowired method used for setting the dataSource
	 * 
	 * @param DataSource dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}
