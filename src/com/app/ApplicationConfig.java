package com.app;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.app.business.SongsBusinessInterface;
import com.app.business.SongsBusinessService;
import com.app.business.UsersBusinessInterface;
import com.app.business.UsersBusinessService;
import com.app.controller.UserController;
import com.app.data.UserDataService;
import com.app.data.interfaces.UserDataAccessInterface;
import com.app.controller.LibraryController;

@Configuration
public class ApplicationConfig {
	
	@Bean(name="userController")
	public UserController getUserController()
	{
		return new UserController();
	}
	

	@Bean(name="usersService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UsersBusinessInterface getUsersService()
	{
		return new UsersBusinessService();
	}
	
	@Bean(name="libraryController")
	public LibraryController getSongController()
	{
		return new LibraryController();
	}
	
	@Bean(name="songsService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public SongsBusinessInterface getSongsService()
	{
		return new SongsBusinessService();
	}
	
	@Bean(name="userDataService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserDataAccessInterface getUserDataService()
	{
		return new UserDataService();
	}
	
	/**
	* Getter for DataSource SpringBean (singleton scoped)
	* @return type DataSource
	*/
	@Bean(name="dataSource", destroyMethod = "close")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataSource getDataSource()
	{
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://www.brendanbrooks.net/cst341");
		dataSource.setUsername("memeboi27");
		dataSource.setPassword("WillIsGay"); 
		dataSource.setInitialSize(2);
		return dataSource;
	}
}
