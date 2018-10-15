package com.app.business;

import java.util.List;

import com.app.model.SongModel;

public interface SongsBusinessInterface {
	public void init();
	public void destroy();
	public boolean addSong(SongModel song);
	public boolean removeSong(int id);
	public SongModel getSongById(int id);
	public List<SongModel> getSongList();
}
