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
 * Using JdbcTemplate to create, read, update, and delete from MySQL DB
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
	 * Create new user method
	 * 
	 * @param UserModel t
	 * @return boolean value
	 */
	@Override
	public boolean create(UserModel t) {
		//create INSERT sql string
		String sql = "INSERT INTO users(firstName, lastName, email, password) VALUES(?, ?, ?, ?)";
		//use a try/catch block to catch exceptions
		try
		{
			//use jdbcTemplateObject to insert new user into db
			int rows = jdbcTemplateObject.update(sql, t.getFirstName(), t.getLastName(), t.getEmail(), t.getPassword());
			
			//return true if rows == 1
			return rows == 1 ? true : false;
			
		}
		//catch exceptions
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Update already existing user method
	 * 
	 * @param UserModel t
	 * @return boolean value
	 */
	@Override
	public boolean update(UserModel t) {
		//create UPDATE sql string
		String sql = "UPDATE users SET firstName=?, lastName=?, email=? WHERE id=?";
		//use a try/catch block to catch exceptions
		try
		{
			//use jdbcTemplateObject to update already existing user
			jdbcTemplateObject.update(sql, t.getFirstName(), t.getLastName(), t.getEmail(), t.getId());
			
			return true;
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Delete already existing user method
	 * 
	 * @param UserModel t
	 * @return boolean value
	 */
	@Override
	public boolean delete(int id) {
		//create DELETE sql string
		String sql = "DELETE FROM users WHERE id=?";
		
		//use a try/catch block to catch exceptions
		try
		{
			int rows = jdbcTemplateObject.update(sql, id);
			
			return rows == 1 ? true : false;
		}catch (Exception e)
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
		//create sql SELECT statement
		String sql = "SELECT * FROM users WHERE email=? AND password=?";
		//create UserModel to represent the user
		UserModel user = new UserModel();
		
		//use a try/catch block to catch exceptions
		try
		{
			//use jdbcTemplateObject to query for user object
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

	/**
	 * Selects user from MySQL db that corresponds with email
	 * 
	 * @param String email
	 * @return UserModel user
	 */
	@Override
	public UserModel findByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email=?";
		UserModel user = new UserModel();
		
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, email);
			if (srs.next())
			{
				user = new UserModel(srs.getInt("id"), srs.getString("firstName"), srs.getString("lastName"), srs.getString("email"), "");
				return user;
			}
			else
			{
				user = new UserModel(-1, "", "", "", "");
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return user;
		}
	}
	
	/**
	 * Update password of already existing user method
	 * 
	 * @param ChangePasswordModel model
	 * @return boolean value
	 */
	@Override
	public boolean updatePassword(ChangePasswordModel model) {
		//create UPDATE sql statement
		String sql = "UPDATE users SET password=? WHERE id=?";
		//use a try/catch block to catch exceptions
		try
		{
			//use jdbcTemplateObject to update password of already existing user
			int rows = jdbcTemplateObject.update(sql, model.getNewPassword(), model.getId());
			
			//if rows == 1 return ttue
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
