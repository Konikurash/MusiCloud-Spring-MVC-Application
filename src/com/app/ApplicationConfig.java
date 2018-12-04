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
import com.app.data.SongDataService;
import com.app.data.UserDataService;
import com.app.data.interfaces.SongDataAccessInterface;
import com.app.data.interfaces.UserDataAccessInterface;
import com.app.controller.LibraryController;

/**
 * Configuration class that handles all spring beans (singleton scoped)
 *
 * @author William Bierer
 * @author Brendan Brooks
 * @version .05
 */
@Configuration
public class ApplicationConfig {
	
	@Bean(name="userController")
	public UserController getUserController()
	{
		return new UserController();
	}
	

	/**
	 * Declares bean for UsersBusinessService (singleton scoped)
	 * 
	 * @return UsersBusinessInterface
	 */
	@Bean(name="usersService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UsersBusinessInterface getUsersService()
	{
		return new UsersBusinessService();
	}
	
	/**
	 * Declares bean for LibraryController (singleton scoped)
	 * 
	 * @return LibraryController
	 */
	@Bean(name="libraryController")
	public LibraryController getSongController()
	{
		return new LibraryController();
	}
	
	/**
	 * Declares bean for SongsBusinessService (singleton scoped)
	 * 
	 * @return SongsBusinessInterface
	 */
	@Bean(name="songsService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public SongsBusinessInterface getSongsService()
	{
		return new SongsBusinessService();
	}
	
	/**
	 * Declares bean for UsersDataService (singleton scoped)
	 * 
	 * @return UsersDataAccessInterface
	 */
	@Bean(name="userDataService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserDataAccessInterface getUserDataService()
	{
		return new UserDataService();
	}
	
	/**
	 * Declares bean for SongsDataService (singleton scoped)
	 * 
	 * @return SongsDataAccessInterface
	 */
	@Bean(name="songDataService")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public SongDataAccessInterface getSongDataService()
	{
		return new SongDataService();
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
		dataSource.setInitialSize(20);
		return dataSource;
	}
}
