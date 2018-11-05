package com.app.data.interfaces;

import java.util.List;

import com.app.model.SongModel;

public interface SongDataAccessInterface extends DataAccessInterface<SongModel> {
	public List<SongModel> findByUserId(int id);
}
