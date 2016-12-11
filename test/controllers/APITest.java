package controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import models.Movie;

public class APITest {
	
	private static RecommenderAPI api;
	private List<Movie> topTenList;
	
	@BeforeClass
	public static void loadData() throws Exception{
		api = new RecommenderAPI();
		api.load();
	}
	@Before
	public void setUp() throws Exception{
		topTenList = new ArrayList<Movie>();
		topTenList.add(api.movieIndex.get(119l));
		topTenList.add(api.movieIndex.get(12l));
		topTenList.add(api.movieIndex.get(22l));
		topTenList.add(api.movieIndex.get(23l));
		topTenList.add(api.movieIndex.get(45l));
		topTenList.add(api.movieIndex.get(48l));
		topTenList.add(api.movieIndex.get(50l));
		topTenList.add(api.movieIndex.get(64l));
		topTenList.add(api.movieIndex.get(79l));
		topTenList.add(api.movieIndex.get(83l));

		
	}
	//Adds 2 new users to the UserIndex, tests to make sure they are added correctly and in the correct position
	@Test
	public void addUserTest() {
		assertEquals(api.userIndex.size(), 943);
		api.addUser("Donal", "Doherty", 18, 'm', "student");
		assertEquals(api.userIndex.size(), 944);
		assertEquals(api.userIndex.get(944l).getFirstName(), "Donal");
		api.addUser("Robbie", "Rotten", 35, 'm', "other");
		assertEquals(api.userIndex.size(), 945);
		assertEquals(api.userIndex.get(945l).getFirstName(), "Robbie");
		System.out.println(api.movieIndex.size());
	}
	//removes one of the new users added to the userindex, and makes sure their position in the index is gone
	@Test
	public void removeUserTest(){
		api.removeUser(945l);
		assertNull(api.userIndex.get(945));
	}
	//adds 2 new movies to MovieIndex, tests to make sure they are added correctly and in correct position
	@Test
	public void addMovieTest(){
		assertEquals(api.movieIndex.size(), 1682);
		api.addMovie("TestMovie", "01-01-2001", "www.test.com");
		assertEquals(api.movieIndex.size(), 1683);
		assertEquals(api.movieIndex.get(1683l).getTitle(), "TestMovie");
		api.addMovie("TestMovie2", "01-01-2002", "www.test.org");
		assertEquals(api.movieIndex.size(), 1684);
		assertEquals(api.movieIndex.get(1684l).getTitle(), "TestMovie2");
	}
	
	//tests the getMovie command.
	@Test
	public void getMovieTest(){
		assertEquals(api.getMovie(1683l).getTitle(), "TestMovie");
	}
	//adds 2 new ratings to rating index, tests to make sure they are added correctly and in correct position in all three places
	@Test
	public void addRatingTest(){
		assertEquals(api.ratingIndex.size(), 100000);
		assertEquals(api.userIndex.get(944l).getRatings().size(), 0);
		api.addRating(944l, 1683l, 5);
		assertEquals(api.ratingIndex.size(), 100001);
		assertEquals(api.userIndex.get(944l).getRatings().size(), 1);
		assertEquals(api.ratingIndex.get(100000).getRating(), 5);
		api.addRating(944l, 1683l, -5);
		assertEquals(api.ratingIndex.size(), 100002);
		assertEquals(api.userIndex.get(944l).getRatings().size(), 2);
		assertEquals(api.ratingIndex.get(100001).getRating(), -5);
	}
	
	//Tests to see if the method returns the arrayList of the users made recommendations.
	//This method doesnt work.
	@Test
	public void getUserRatingsTest(){
		assertEquals(api.getUserRatings(660l).size(), 1);
	}

	//Tests to see if the top ten movies are correct
	@Test
	public void getTopTenMoviesTest() throws Exception
	{
		assertEquals(api.getTopTenMovies().toString(), topTenList.toString());
	}
	//Tests to see if an xml data file is created
	@Test 
	public void writeTest() throws Exception{
		api.write();
		assertTrue(api.data.isFile());
	}
	
	//Test to check that the correct recomendations are being returned.
	@Test
	public void getUserRecommendationsTest(){
		assertEquals(api.getUserRecommendations(20l).toString(), 1);
	}

}
