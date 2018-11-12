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

@Controller
@RequestMapping("/library")
public class LibraryController {
	
	SongsBusinessInterface songService;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(path="/main", method=RequestMethod.GET)
	public ModelAndView displayLibrary()
	{
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		//System.out.println(sessionUser.getId());
		ModelAndView mv = new ModelAndView();
		
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
	
	@RequestMapping(path="/addSong", method=RequestMethod.POST)
	public ModelAndView addSong(@Valid @ModelAttribute("song")SongModel song, BindingResult resultSong)
	{
		ModelAndView mv = new ModelAndView();
		//The song list will be needed if there are errors or not, so we retrieve it right away
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		if(sessionUser == null || sessionUser.getId() == -1)
		{
			mv.setViewName("redirect: /MusiCloud");
			return mv;
		}
		
		mv.addObject("songs", songService.getSongListByUserId(sessionUser.getId()));
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
		songService.addSong(song);
		mv.addObject("editSong", new SongModel());
		mv.addObject("songs", songService.getSongListByUserId(sessionUser.getId()));
		mv.setViewName("main");
		
		return mv;
	}
	
	@RequestMapping(path="/deleteSong/{id}", method=RequestMethod.GET)
	public ModelAndView deleteSong(@PathVariable int id)
	{
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		
		ModelAndView mv = new ModelAndView();
		if(sessionUser == null || sessionUser.getId() == -1)
		{
			mv.setViewName("redirect: /MusiCloud");
			return mv;
		}
		
		songService.removeSong(id, sessionUser.getId());
		mv.addObject("songs" ,songService.getSongListByUserId(sessionUser.getId()));
		mv.addObject("song", new SongModel());
		mv.addObject("editSong", new SongModel());
		mv.setViewName("main");
		
		return mv;
		
	}
	
	@RequestMapping(path="/updateSong", method=RequestMethod.POST)
	public ModelAndView updateSong(@ModelAttribute("editSong")SongModel editSong, BindingResult editResult)
	{
		UserModel sessionUser = (UserModel) httpSession.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		if(sessionUser == null || sessionUser.getId() == -1)
		{
			mv.setViewName("redirect: /MusiCloud");
			return mv;
		}
		
		mv.addObject("songs", songService.getSongListByUserId(sessionUser.getId()));
		editSong.setuserID(sessionUser.getId());
		editSong.setMp3Path("/assets/mp3/Ghost of Days Gone By.m4a");
		songService.updateSong(editSong);
	
		mv.addObject("song", new SongModel());
		mv.addObject("editSong", editSong);
		mv.setViewName("main");
		return mv;
		
	}
	
	@Autowired
	public void setSongsService(SongsBusinessInterface service)
	{
		this.songService = service;
	}
}
