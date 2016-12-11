package models;

import java.util.ArrayList;

public class Movie implements Comparable<Movie>{
	static Long counter = 0l;
	
	private Long id;
	private String title;
	private String year;
	private String url;
	private int avg;
	private ArrayList<Rating> ratings;
	
	public Movie(String title, String year, String url)
	{ 
		ratings = new ArrayList<Rating>();
		avg = 0;
		this.id = counter++;
		this.title = title;
		this.year = year;
		this.url = url;
	}
	
	public Movie(Long id, String title, String year, String url)
	{
		ratings = new ArrayList<Rating>();
		avg = 0;
		this.id = id;
		this.title = title;
		this.year = year;
		this.url = url;
	}
	//this method will calculate the average rating of the movie
	public void computeRating()
	{
		if(ratings.size()<=0)
		{
			avg = 0; 
		}
		else
		{
			int calc = 0;
			for(Rating r : ratings)
			{
				calc = r.getRating() + calc;
			}
			avg = calc/ratings.size();
		}
	}

	
	public String toString()
	{
		return "ID= " + id + " Title= " + title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public int compareTo(Movie compMovie) {
		int compareQuantity = ((Movie) compMovie).getAvg();
		return compareQuantity - this.avg;
	}
}
