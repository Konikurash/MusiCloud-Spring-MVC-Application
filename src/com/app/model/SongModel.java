package com.app.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model used for handling song data throughout the application
 * Used in data and business layer
 *
 * @author William Bierer
 * @author Brendan Brooks
 * @version .05
 */
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
	@Min(value=1800, message="Unreasonable Year")
	@Max(value=3000, message="Unreasonable Year")
	private int year;
	private String mp3Path;
	private int userID;
	
	/**
	 * Default constructor method
	 * 
	 * 
	 */
	public SongModel() {
		this.id = -1;
		this.title = "";
		this.artist = "";
		this.album = "";
		this.year = 2018;
		this.mp3Path = "";
		this.userID = -1;
	}

	/**
	 * Non default constructor method
	 * 
	 * @param int id : represents song id in MySQL database
	 * @param String title : represents song title
	 * @param String artist : represents song artist
	 * @param String album : represents song album
	 * @param int year : represents song release year
	 * @param String mp3Path : represents path to mp3 file
	 * @param int userID : represents user ID of song uploader
	 */
	public SongModel(int id, String title, String artist, String album, int year, String mp3Path, int userID) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.mp3Path = mp3Path;
		this.userID = userID;
	}
	
	/**
	 * Getter method for id
	 * 
	 *
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id
	 * 
	 *
	 * @param int id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Getter method for title
	 * 
	 *
	 * @return String title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter method for title
	 * 
	 *
	 * @param String title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Getter method for artist
	 * 
	 *
	 * @return String artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Setter method for artist
	 * 
	 *
	 * @param String atrist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/**
	 * Getter method for album
	 * 
	 *
	 * @return String album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * Setter method for album
	 * 
	 *
	 * @param String album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	
	/**
	 * Getter method for year
	 * 
	 *
	 * @return int year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Setter method for year
	 * 
	 *
	 * @param int year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Getter method for mp3Path
	 * 
	 *
	 * @return String mp3Path
	 */
	public String getMp3Path() {
		return mp3Path;
	}

	/**
	 * Setter method for mp3Path
	 * 
	 *
	 * @param String mp3Path
	 */
	public void setMp3Path(String mp3Path) {
		this.mp3Path = mp3Path;
	}

	/**
	 * Getter method for userID
	 * 
	 *
	 * @return int userID
	 */
	public int getuserID() {
		return userID;
	}

	/**
	 * Setter method for userID
	 * 
	 *
	 * @param int userID
	 */
	public void setuserID(int userID) {
		this.userID = userID;
	}
		
}
