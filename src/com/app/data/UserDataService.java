package com.app.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.app.data.interfaces.UserDataAccessInterface;
import com.app.model.UserModel;

public class UserDataService implements UserDataAccessInterface {
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

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

	@Override
	public boolean update(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserModel findByObject(UserModel t) {
		String sql = "SELECT * FROM users WHERE email='?' AND password='?'";
		UserModel user = new UserModel();
		
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			if (srs.next())
			{
				user = new UserModel(srs.getInt("id"), srs.getString("firstName"), srs.getString("lastName"), srs.getString("email"), "");
				return user;
			}
			else
			{
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
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}
