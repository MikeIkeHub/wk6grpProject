import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.ShowDao;
import entity.Show;

public class Menu {
	
	private ShowDao showDao = new ShowDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Shows",
			"Add a Show",
			"Update a Show",
			"Delete a Show")
			"Display Movies",
			"Add a Movie",
			"Update a Movie",
			"Delete a Movie";
	
	public void start() {
		String input = "";
		do {
			printMenu();
			input = scanner.nextLine();
			try {
			if(input.equals("0")) {
				readShows();
			} else if (input.equals("1")) {
				addShow();
			} else if (input.equals("2")) {
				updateShow();
			} else if (input.equals("3")) {
				deleteShow();
			} else if (input.equals("4")) {
				readMovies();
			} else if (input.equals("5")) {
				addMovie();
			} else if (input.equals("6")) {
				updateMovie();
			} else if (input.equals("7")) {
				deleteMovie();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Press enter to return to menu");
			scanner.nextLine();
		} while (!input.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an option:\n");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + ") " + options.get(i));
		}
	}
	
	private void readShows() throws SQLException {
		List<Show> shows = showDao.getShows();
		for (Show show : shows) {
			System.out.println(show.getShowId() + ": " + show.getShowName());
		}
	}
		
	private void readMovies() throws SQLException {
		List<Movie> movies = movieDao.getMovies();
		for (Movie movie : movies) {
			System.out.println(movie.getMovieId() + ": " + movie.getMovieName());
		}
	}
	
	}
	
	private void addShow() throws SQLException {
		System.out.print("Enter show name:");
		String showName = scanner.nextLine();
		showDao.addNewShow(showName);
	}
	
	private void updateShow() throws SQLException {
		System.out.println("Please enter the id of show you would like to update");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Please input your update");
		String showName = scanner.nextLine();
		showDao.updateShow(id, showName);
	}
	
	private void deleteShow() throws SQLException {
		System.out.println("Enter number of show to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		showDao.deleteShow(id);
	}
	
	private void readMovies() throws SQLException {
		List<Movie> movies = movieDao.getMovies();
		for (Movie movie : movies) {
			System.out.println(movie.getmovieId() + ": " + movie.getmovieName());
		}
	}
	
	private void addMovie() throws SQLException {
		System.out.print("Enter show name:");
		String movieName = scanner.nextLine();
		movieDao.addNewMovie(movieName);
	}
	
	private void updateMovie() throws SQLException {
		System.out.println("Please enter the id of show you would like to update");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Please input your update");
		String movieName = scanner.nextLine();
		movieDao.updateMovie(id, movieName);
	}
	
	private void deleteMovie() throws SQLException {
		System.out.println("Enter number of show to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		movieDao.deleteMovie(id);
	}
	
}
