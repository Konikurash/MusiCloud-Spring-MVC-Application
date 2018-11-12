package com.app.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.interfaces.SongDataAccessInterface;
import com.app.model.SongModel;

public class SongsBusinessService implements SongsBusinessInterface <SongModel> {
	
	private SongDataAccessInterface songDataService;
	
	public SongsBusinessService()
	{

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
	public boolean removeSong(int id, int userId) {
		
		return songDataService.delete(id, userId);
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

	@Override
	public boolean updateSong(SongModel song) {
		return songDataService.update(song);
	}

}