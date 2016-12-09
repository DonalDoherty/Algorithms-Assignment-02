package models;

public class Rating {
		
	public Long userID;
	public Long movieID;
	public int rating;
	
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
}
