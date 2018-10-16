package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.app.business.SongsBusinessInterface;
import com.app.business.SongsBusinessService;
import com.app.business.UsersBusinessInterface;
import com.app.business.UsersBusinessService;
import com.app.controller.UserController;
import com.app.controller.LibraryController;

@Configuration
public class ApplicationConfig {
	
	@Bean(name="userController")
	public UserController getUserController()
	{
		return new UserController();
	}
	
	@Bean(name="usersService", initMethod="init", destroyMethod="destroy")
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
	
	@Bean(name="songsService", initMethod="init", destroyMethod="destroy")
	@Scope(value="singleton", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public SongsBusinessInterface getSongsService()
	{
		return new SongsBusinessService();
	}
}
