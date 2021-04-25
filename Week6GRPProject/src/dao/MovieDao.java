package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Show;

public class MovieDao {

	private Connection connection;
	private final String GET_MOVIES_QUERY = "SELECT * FROM movies";
	private final String ADD_NEW_MOVIE = "INSERT INTO movies(name) VALUES(?)";
	private final String UPDATE_MOVIE = "UPDATE movies SET name = (?) WHERE id = (?)";
	private final String DELETE_MOVIE_BY_ID = "DELETE FROM movies WHERE id = (?)";
	
	public MovieDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Movie> getMovies() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_MOVIES_QUERY).executeQuery();
		
		List<Movie> movies = new ArrayList<Movie>();
		
		while(rs.next()) {
			movies.add(new Movie(rs.getInt(1), rs.getString(2)));
		}
		
		return movies;
	}
	
	public void addNewMovie(String movieName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(ADD_NEW_MOVIE);
		ps.setString(1, movieName);
		ps.executeUpdate();
	}
	
	public void updateMovie(int id, String movieName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_MOVIE);
		ps.setString(1, movieName);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	
	public void deleteMovie(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_MOVIE_BY_ID);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
