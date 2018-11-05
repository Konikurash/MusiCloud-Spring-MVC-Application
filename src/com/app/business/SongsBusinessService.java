package com.app.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.interfaces.SongDataAccessInterface;
import com.app.model.SongModel;

public class SongsBusinessService implements SongsBusinessInterface {
	
	private SongDataAccessInterface songDataService;
	
	public SongsBusinessService()
	{
		//songs.add(new SongModel(1, "For The One", "Rezwana Derbyshire & Brendan Brooks", "For The One", 2018, "/assets/mp3/Demo10-FTO.mp3", "bbrooksgo@gmail.com"));
		//songs.add(new SongModel(3, "Traipse", "Tremonti", "A Dying Machine", 2018, "/assets/mp3/Traipse.m4a", "bbrooksgo@gmail.com"));
	}

	@Override
	public boolean addSong(SongModel song) {
		if(song.equals(null))
		{
			System.out.println("Error in SongBusinessService.addSong");
			return false;
		}
		
		return songDataService.create(song);
	}

	@Override
	public boolean removeSong(int id) {
		SongModel s = getSongById(id);
		return true;
	}

	public SongModel getSongById(int id) {
		return null;
	}

	@Override
	public List<SongModel> getSongList() {
		
		return null;
	}
	
	@Override
	public void clearList()
	{
		
	}
	
	@Autowired
	public void setSongDataAccessInterface(SongDataAccessInterface service)
	{
		this.songDataService = service;
	}

	@Override
	public List<SongModel> getSongListByUserId(int id) {
		// TODO Auto-generated method stub
		return songDataService.findByUserId(id);
	}

}
