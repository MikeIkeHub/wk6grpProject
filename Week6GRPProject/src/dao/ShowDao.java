package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Show;

public class ShowDao {
	private Connection connection;
	private final String GET_SHOWS_QUERY = "SELECT * FROM shows";
	private final String ADD_NEW_SHOW = "INSERT INTO shows(name) VALUES(?)";
	private final String UPDATE_SHOW = "UPDATE shows SET name = (?) WHERE id = (?)";
	private final String DELETE_SHOW_BY_ID = "DELETE FROM shows WHERE id = (?)";
	
	public ShowDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Show> getShows() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_SHOWS_QUERY).executeQuery();
		
		List<Show> shows = new ArrayList<Show>();
		
		while(rs.next()) {
			shows.add(new Show(rs.getInt(1), rs.getString(2)));
		}
		
		return shows;
	}
	
	public void addNewShow(String showName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_NEW_SHOW);
		ps.setString(1, showName);
		ps.executeUpdate();
	}
	
	public void updateShow(int id, String showName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_SHOW);
		ps.setString(1, showName);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void deleteShow(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_SHOW_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
