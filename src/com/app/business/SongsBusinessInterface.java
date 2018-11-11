package com.app.business;

import java.util.List;

import com.app.model.SongModel;

public interface SongsBusinessInterface {
	public boolean addSong(SongModel song);
	public boolean removeSong(int id);
	public SongModel getSongById(int id);
	public List<SongModel> getSongList();
	public List<SongModel> getSongListByUserId(int id);
	public void clearList();
}
