package controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import models.Movie;

public class APITest {
	
	private RecommenderAPI api;
	private List<Movie> topTenList;
	
	@Before
	public void setUp() throws Exception{
		api = new RecommenderAPI();
		api.load();
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

	@Test
	public void addUserTest() {
		assertEquals(api.userIndex.size(), 943);
		api.addUser("Donal", "Doherty", 18, 'm', "student");
		assertEquals(api.userIndex.size(), 944);
		assertEquals(api.userIndex.get(944l).getFirstName(), "Donal");
		api.addUser("Robbie", "Rotten", 35, 'm', "other");
		assertEquals(api.userIndex.size(), 945);
		assertEquals(api.userIndex.get(945l).getFirstName(), "Robbie");
	}
	
	@Test
	public void getTopTenMoviesTest() throws Exception
	{
		assertEquals(api.getTopTenMovies().toString(), topTenList.toString());
	}

}
