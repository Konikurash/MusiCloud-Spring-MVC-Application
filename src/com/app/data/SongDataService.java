package com.app.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.app.data.interfaces.SongDataAccessInterface;
import com.app.model.SongModel;

/**
 * Data service for songs.  Reads and writes to MySQL DB
 *
 * @author William Bierer
 * @author Brendan Brooks
 * @version .05
 */
public class SongDataService implements SongDataAccessInterface {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	/**
	 * Create song method
	 * 
	 * @param SongModel t
	 * @return boolean value
	 */
	@Override
	public boolean create(SongModel t) {
		String sql = "INSERT INTO song(TITLE, ALBUM, ARTIST, MP3PATH, USERID, YEAR) VALUES(?, ?, ?, ?, ?, ?)";
		try
		{
			int rows = jdbcTemplateObject.update(sql, t.getTitle(), t.getAlbum(), t.getArtist(), t.getMp3Path(), t.getuserID(), t.getYear());
			
			return rows == 1 ? true : false;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	/**
	 * Update song method
	 * 
	 * @param SongModel t
	 * @return boolean value
	 */
	@Override
	public boolean update(SongModel t) {
		String sql = "UPDATE song SET TITLE = ?, ALBUM= ?, ARTIST= ?, YEAR = ?, MP3PATH = ? WHERE ID = ? AND USERID = ?";
		
		try {
			jdbcTemplateObject.update(sql, t.getTitle(), t.getAlbum(), t.getArtist(), t.getYear(), t.getMp3Path(), t.getId(), t.getuserID());
			
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

	/**
	 * Delete song method
	 * 
	 * @param int id
	 * @param int userId
	 * @return boolean value
	 */
	@Override
	public boolean delete(int id, int userId) {
String sql = "DELETE FROM song WHERE ID = ? AND USERID = ?";
		
		try {
			int rows = jdbcTemplateObject.update(sql, id, userId);
			
			return rows == 1 ? true : false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public SongModel findByObject(SongModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SongModel findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets list of songs using UserID as where clause
	 * 
	 * @param int id
	 * @return List<SongModel>
	 */
	@Override
	public List<SongModel> findByUserId(int id) {
		String sql = "SELECT * FROM song WHERE USERID = ?";
		List<SongModel> songList = new ArrayList<SongModel>();
		
		try
		{
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, id);
			while(srs.next())
			{
				songList.add(new SongModel(srs.getInt("ID"), srs.getString("TITLE"), srs.getString("ARTIST"), srs.getString("ALBUM"), srs.getInt("YEAR"), srs.getString("MP3PATH"), srs.getInt("USERID")));
				System.out.println(srs.getString("TITLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return songList;
	}
	
	/**
	 * Audiowired method used for setting the dataSource
	 * 
	 * @param DataSource dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}
