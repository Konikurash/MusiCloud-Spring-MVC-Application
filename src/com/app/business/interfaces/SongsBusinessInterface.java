package com.app.business.interfaces;

import java.util.List;

import com.app.model.SongModel;

public interface SongsBusinessInterface <T> {
	public boolean addSong(T song);
	public boolean removeSong(int id, int userId);
	public boolean updateSong(T song);
	public SongModel getSongById(int id);
	public List<SongModel> getSongList();
	public List<SongModel> getSongListByUserId(int id);
	public void clearList();
}
