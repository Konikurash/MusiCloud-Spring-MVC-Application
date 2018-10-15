package com.app.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SongModel {
	
	private int id;
	@NotNull(message="Song title is required.")
	@Size(min=1, max=100, message="Song title must be between 1 and 100 characters")
	private String title;
	@NotNull(message="Artist is required.")
	@Size(min=1, max=100, message="Artist must be between 1 and 100 characters")
	private String artist;
	@NotNull(message="Album title is required.")
	@Size(min=1, max=100, message="Album Title must be between 1 and 100 characters")
	private String album;
	@NotNull(message="Year is required.")
	@Size(min=1, max=100, message="Year must be between 1 and 5 characters")
	private int year;
	private String mp3Path;
	private String ownerEmail;
	
	public SongModel() {
		this.id = 0;
		this.title = "";
		this.artist = "";
		this.album = "";
		this.year = 2070;
		this.mp3Path = "";
		this.ownerEmail = "";
	}

	public SongModel(int id, String title, String artist, String album, int year, String mp3Path, String ownerEmail) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.mp3Path = mp3Path;
		this.ownerEmail = ownerEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMp3Path() {
		return mp3Path;
	}

	public void setMp3Path(String mp3Path) {
		this.mp3Path = mp3Path;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
		
}
