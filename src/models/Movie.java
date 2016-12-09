package models;


public class Movie {
	static Long counter = 0l;
	
	public Long id;
	public String title;
	public String year;
	public String url;

	
	public Movie(String title, String year, String url)
	{
		this.id = counter++;
		this.title = title;
		this.year = year;
		this.url = url;
	}
	
	public Movie(Long id, String title, String year, String url)
	{
		this.id = id;
		this.title = title;
		this.year = year;
		this.url = url;
	}

	
	public String toString()
	{
		return "ID= " + id + " Title= " + title;
	}
}
