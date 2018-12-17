package com.app.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.data.interfaces.SongDataAccessInterface;
import com.app.model.SongModel;

/**
 * Business service for songs.  utilizes songDataService
 *
 * @author William Bierer
 * @author Brendan Brooks
 * @version .05
 */
public class SongsBusinessService implements SongsBusinessInterface <SongModel> {
	
	private SongDataAccessInterface songDataService;
	
	/**
	 * Default constructor
	 */
	public SongsBusinessService()
	{

	}

	/**
	 * add new song method
	 * 
	 * @param SongModel song
	 * @return boolean value
	 */
	@Override
	public boolean addSong(SongModel song) {
		if(song.equals(null))
		{
			System.out.println("Error in SongBusinessService.addSong");
			return false;
		}
		
		//use data service to create new song
		return songDataService.create(song);
	}

	/**
	 * remove existing song method
	 * 
	 * @param int id
	 * @param int userId
	 * @return boolean value
	 */
	@Override
	public boolean removeSong(int id, int userId) {
		//use data service to delete song
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
	
	/**
	 * Autowired method for setting songDataService to SongDataAccessInterface
	 * 
	 * @param SongDataAccessInterface service
	 */
	@Autowired
	public void setSongDataAccessInterface(SongDataAccessInterface service)
	{
		this.songDataService = service;
	}

	/**
	 * Gets list of songs based on userId
	 * 
	 * @param int id
	 * @return List<SongModel>
	 */
	@Override
	public List<SongModel> getSongListByUserId(int id) {
		//use data service to find list of songs by user id
		return songDataService.findByUserId(id);
	}
	
	/**
	 * Update existing song method
	 * 
	 * @param SongModel song
	 * @return boolean value
	 */
	@Override
	public boolean updateSong(SongModel song) {
		//use data service to update song
		return songDataService.update(song);
	}

}