package entity;

public class Movies {

	private int movieId;
	private String movieName;
	
	public Movies(int movieId, String movieName) {
		this.setmovieId(movieId);
		this.setmovieName(movieName);
	}
	public int getmovieId() {
		return movieId;
	}

	public void setmovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getmovieName() {
		return movieName;
	}

	public void setmovieName(String movieName) {
		this.movieName = movieName;
	}
}
