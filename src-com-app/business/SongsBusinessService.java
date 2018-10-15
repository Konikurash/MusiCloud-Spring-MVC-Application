package com.app.business;

import java.util.ArrayList;
import java.util.List;

import com.app.model.SongModel;

public class SongsBusinessService implements SongsBusinessInterface {
	
	private List<SongModel> songs = new ArrayList<SongModel>();

	@Override
	public void init() {
		System.out.println("Hello from SongsBusinessService.init");

	}

	@Override
	public void destroy() {
		System.out.println("Hello from SongsBusinessService.destroy");

	}

	@Override
	public boolean addSong(SongModel song) {
		if(song.equals(null))
		{
			System.out.println("Error in SongBusinessService.addSong");
			return false;
		}
		songs.add(song);
		return true;
	}

	@Override
	public boolean removeSong(int id) {
		SongModel s = getSongById(id);
		songs.remove(s);
		return true;
	}

	public SongModel getSongById(int id) {
		for(SongModel s : songs)
		{
			if(s.getId() == id)
			{
				return s;
			}
		}
		System.out.println("Song does not exist");
		return null;
	}

	@Override
	public List<SongModel> getSongList() {
		return songs;
	}

}
