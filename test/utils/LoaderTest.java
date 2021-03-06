package utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import models.Movie;
import models.Rating;
import models.User;

import org.junit.Before;

public class LoaderTest {
	//In the interest of  time only the small files were used for the tests, as the large files are the exact same format, if the small files pass the test then the large fills will.
	//Also, a custom ratings file was used, as even the small ratings file would be too tedious to write tests for
	private CSVLoader loader;
	private String smallUsers;
	private String smallMovies;
	private String smallRatings;
	private List<User> users;
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	private User user5;
	private List<Movie> movies;
	private Movie movie1;
	private Movie movie2;
	private Movie movie3;
	private Movie movie4;
	private Movie movie5;
	private Movie movie6;
	private Movie movie7;
	private Movie movie8;
	private Movie movie9;
	private Movie movie10;

	private List<Rating> ratings;
	private Rating rating1;
	private Rating rating2;
	private Rating rating3;
	private Rating rating4;
	private Rating rating5;


	@Before
	public void setUp()
	{
		loader = new CSVLoader();
		smallUsers = "Data/users5.dat";
		smallMovies = "Data/items5.dat";
		smallRatings = "Data/smallRatings.dat";
		//Setting up a List of type user that is identical to what SHOULD be output when the CSVLoader reads in users5.
		user1 = new User(1l, "Leonard", "Hernandez", 'M', 24, "technician");
		user2 = new User(2l, "Melody", "Roberson", 'F', 53, "other");
		user3 = new User(3l, "Gregory", "Newton", 'M', 23, "writer");
		user4 = new User(4l, "Oliver", "George", 'M', 24, "technician");
		user5 = new User(5l, "Jenna", "Parker", 'F', 33, "other");
		users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		//Doing the same With Movies
		movie1 = new Movie(1l, "Toy Story (1995)", "01-Jan-1995", "http://us.imdb.com/M/title-exact?Toy%20Story%20(1995)");
		movie2 = new Movie(2l, "GoldenEye (1995)", "01-Jan-1995", "http://us.imdb.com/M/title-exact?GoldenEye%20(1995)");
		movie3 = new Movie(3l, "Four Rooms (1995)", "01-Jan-1995", "http://us.imdb.com/M/title-exact?Four%20Rooms%20(1995)");
		movie4 = new Movie(4l, "Get Shorty (1995)", "01-Jan-1995", "http://us.imdb.com/M/title-exact?Get%20Shorty%20(1995)");
		movie5 = new Movie(5l, "Copycat (1995)", "01-Jan-1995", "http://us.imdb.com/M/title-exact?Copycat%20(1995)");
		movie6 = new Movie(6l, "Shanghai Triad (Yao a yao yao dao waipo qiao) (1995)", "01-Jan-1995", "http://us.imdb.com/Title?Yao+a+yao+yao+dao+waipo+qiao+(1995)");
		movie7 = new Movie(7l, "Twelve Monkeys (1995)", "01-Jan-1995", "http://us.imdb.com/M/title-exact?Twelve%20Monkeys%20(1995)");
		movie8 = new Movie(8l, "Babe (1995)", "01-Jan-1995", "http://us.imdb.com/M/title-exact?Babe%20(1995)");
		movie9 = new Movie(9l, "Dead Man Walking (1995)", "01-Jan-1995", "http://us.imdb.com/M/title-exact?Dead%20Man%20Walking%20(1995)");
		movie10 = new Movie(10l, "Richard III (1995)", "01-Jan-1996", "http://us.imdb.com/M/title-exact?Richard%20III%20(1995)");
		movies = new ArrayList<Movie>();
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		movies.add(movie5);
		movies.add(movie6);
		movies.add(movie7);
		movies.add(movie8);
		movies.add(movie9);
		movies.add(movie10);
		//And finally for ratings
		rating1 = new Rating(2l, 10l, 1);
		rating2 = new Rating(2l, 10l, 1);
		rating3 = new Rating(4l, 10l, 3);
		rating4 = new Rating(4l, 10l, 5);
		rating5 = new Rating(5l, 10l, -5);
		ratings = new ArrayList<Rating>();
		ratings.add(rating1);
		ratings.add(rating2);
		ratings.add(rating3);
		ratings.add(rating4);
		ratings.add(rating5);

	}
	@Test
	public void testLoadUsers() throws Exception {
		assertEquals(loader.loadUsers(smallUsers).toString(), users.toString());
	}
	
	@Test
	public void testLoadMovies() throws Exception
	{
		assertEquals(loader.loadMovies(smallMovies).toString(), movies.toString());
	}
	
	@Test
	public void testLoadRatings() throws Exception
	{
		assertEquals(loader.loadRatings(smallRatings).toString(), ratings.toString());
	}

}
