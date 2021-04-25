package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.JapaneseShows;

public class JapaneseShowsDao {
	private Connection connection;
	private final String GET_JSHOWS_QUERY = "SELECT * FROM japanese_shows";
	private final String ADD_NEW_JSHOW = "INSERT INTO japanese_shows(name, animated) VALUES(?, ?)";
	private final String UPDATE_JSHOW = "UPDATE japanese_shows SET name = (?), animated = (?) WHERE id = (?)";
	private final String DELETE_JSHOW_BY_ID = "DELETE FROM japanese_shows WHERE id = (?)";
	
	public JapaneseShowsDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<JapaneseShows> getjShows() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_JSHOWS_QUERY).executeQuery();
		
		List<JapaneseShows> jShows = new ArrayList<JapaneseShows>();
		
		while(rs.next()) {
			jShows.add(new JapaneseShows(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
		return jShows;
	}
	
	public void addNewjShow(String jShowName, String animated) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_NEW_JSHOW);
		ps.setString(1, jShowName);
		ps.setString(2, animated);
		ps.executeUpdate();
	}
	
	public void updatejShow(int id, String jShowName, String animated) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_JSHOW);
		ps.setInt(3, id);
		ps.setString(1, jShowName);
		ps.setString(2, animated);
		ps.executeUpdate();
	}
	
	public void deletejShow(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_JSHOW_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
}