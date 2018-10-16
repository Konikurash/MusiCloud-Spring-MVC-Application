package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.business.SongsBusinessInterface;
import com.app.model.SongModel;

import javax.validation.Valid;

@Controller
@RequestMapping("library")
public class LibraryController {
	
	SongsBusinessInterface songService;
	//temporary id object until we setup MySQL/Derby DB
	private int songID = 0;
	
	@RequestMapping(path="main", method=RequestMethod.GET)
	public ModelAndView displayLibrary()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("songs", songService.getSongList());
		mv.setViewName("main");
		
		return mv;
	}
	
	@RequestMapping(path="/addSong", method=RequestMethod.POST)
	public ModelAndView addSong(@Valid @ModelAttribute("song")SongModel song, BindingResult resultSong)
	{
		ModelAndView mv = new ModelAndView();
		
		if(resultSong.hasErrors())
		{
			mv.addObject("song", song);
			mv.setViewName("addSong");
			
			return mv;
		}
		
		song.setId(songID);
		songID++;
		songService.addSong(song);
		mv.addObject(songService.getSongList());
		mv.setViewName("main");
		
		return mv;
	}
	
	@RequestMapping(path="/deleteSong", method=RequestMethod.POST)
	public ModelAndView deleteSong(@ModelAttribute("song")SongModel song)
	{
		ModelAndView mv = new ModelAndView();
		
		songService.removeSong(song.getId());
		mv.addObject(songService.getSongList());
		mv.setViewName("main");
		
		return mv;
		
	}
}
