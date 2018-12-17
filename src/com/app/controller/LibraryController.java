package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.business.SongsBusinessInterface;
import com.app.model.SongModel;
import com.app.model.UserModel;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Controller for handling all song related Requests
 * Uses SongBusinessService
 *
 * @author William Bierer
 * @author Brendan Brooks
 * @version .05
 */
@Controller
@RequestMapping("/library")
public class LibraryController {
	
	private SongsBusinessInterface songService;
	
	@Autowired
	private HttpSession httpSession;
	
	/**
	 * Method that displays songs uploaded by the user to the main view
	 * Maps to /main
	 * 
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/main", method=RequestMethod.GET)
	public ModelAndView displayLibrary()
	{
		//get user from the session
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		//System.out.println(sessionUser.getId());
		ModelAndView mv = new ModelAndView();
		
		//check if sessionUser exists. if not, redirect to login view
		if(sessionUser == null || sessionUser.getId() == -1)
		{
			mv.setViewName("redirect: /MusiCloud");
			return mv;
		}
		

		mv.addObject("songs", songService.getSongListByUserId(sessionUser.getId()));
		mv.addObject("song", new SongModel());
		mv.addObject("editSong", new SongModel());
		mv.setViewName("main");
		
		return mv;
	}
	
	/**
	 * Method that adds a new song to the database using songService
	 * Maps to /addSong
	 * 
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/addSong", method=RequestMethod.POST)
	public ModelAndView addSong(@Valid @ModelAttribute("song")SongModel song, BindingResult resultSong)
	{
		ModelAndView mv = new ModelAndView();
		//The song list will be needed if there are errors or not, so we retrieve it right away
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		
		//check if sessionUser exists. if not, redirect to login view
		if(sessionUser == null || sessionUser.getId() == -1)
		{
			mv.setViewName("redirect: /MusiCloud");
			return mv;
		}
		
		
		mv.addObject("songs", songService.getSongListByUserId(sessionUser.getId()));
		//check for form errors
		if(resultSong.hasErrors())
		{
			mv.addObject("song", song);
			mv.addObject("editSong", new SongModel());
			mv.setViewName("main");
			
			return mv;
		}
		
		
		//Using a song that already exists for now, until we learn how to handle files in Spring
		song.setMp3Path("/assets/mp3/Ghost of Days Gone By.m4a");
		song.setuserID(sessionUser.getId());
		//use business service to add new song to the database
		songService.addSong(song);
		mv.addObject("editSong", new SongModel());
		mv.addObject("songs", songService.getSongListByUserId(sessionUser.getId()));
		mv.setViewName("redirect: /MusiCloud/library/main");
		
		return mv;
	}
	
	/**
	 * Method that deletes a song from the database using songService
	 * gets the songID from the URI
	 * Maps to /deleteSong/{id}
	 * 
	 * @param int id
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/deleteSong/{id}", method=RequestMethod.GET)
	public ModelAndView deleteSong(@PathVariable int id)
	{
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		
		ModelAndView mv = new ModelAndView();
		//check if sessionUser exists. if not, redirect to login view
		if(sessionUser == null || sessionUser.getId() == -1)
		{
			mv.setViewName("redirect: /MusiCloud");
			return mv;
		}
		
		//use business service to delete song from database
		songService.removeSong(id, sessionUser.getId());
		mv.addObject("songs" ,songService.getSongListByUserId(sessionUser.getId()));
		mv.addObject("song", new SongModel());
		mv.addObject("editSong", new SongModel());
		mv.setViewName("redirect: /MusiCloud/library/main");
		
		return mv;
		
	}
	
	/**
	 * Method that updates a song from the database using songService
	 * Maps to /updateSong
	 * 
	 * @param SongModel editSong
	 * @param BindingResult editResult
	 * @return ModelAndView mv
	 */
	@RequestMapping(path="/updateSong", method=RequestMethod.POST)
	public ModelAndView updateSong(@ModelAttribute("editSong")SongModel editSong, BindingResult editResult)
	{
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		//check if sessionUser exists. if not, redirect to login view
		if(sessionUser == null || sessionUser.getId() == -1)
		{
			mv.setViewName("redirect: /MusiCloud");
			return mv;
		}
		
		//get arrayList of songs from business service
		mv.addObject("songs", songService.getSongListByUserId(sessionUser.getId()));
		editSong.setuserID(sessionUser.getId());
		editSong.setMp3Path("/assets/mp3/Ghost of Days Gone By.m4a");
		//update using the business service
		songService.updateSong(editSong);
	
		//redirect back to the main view upon successful update
		mv.addObject("song", new SongModel());
		mv.addObject("editSong", editSong);
		mv.setViewName("redirect: /MusiCloud/library/main");
		return mv;
		
	}
	
	/**
	 * Autowired method that sets the songService
	 * 
	 * @param SongsBusinessInterface service
	 */
	@Autowired
	public void setSongsService(SongsBusinessInterface service)
	{
		this.songService = service;
	}
}
