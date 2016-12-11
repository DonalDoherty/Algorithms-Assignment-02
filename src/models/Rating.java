package models;

public class Rating {
		
	private Long userID;
	private Long movieID;
	private int rating;
	
	public Rating(Long userID, Long movieID, int rating)
	{
		this.userID = userID;
		this.movieID = movieID;
		this.rating = rating;
	}
		
	public String toString()
	{
		return "UserID =" + userID + " MovieID = " + movieID + " Rating= " + rating;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getMovieID() {
		return movieID;
	}

	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
