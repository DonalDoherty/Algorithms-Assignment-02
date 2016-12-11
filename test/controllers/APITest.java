package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class APITest {
	
	private RecommenderAPI api;
	
	@Before
	public void setUp() throws Exception{
		api = new RecommenderAPI();
	}

	@Test
	public void addUserTest() {
		api.addUser("Donal", "Doherty", 18, 'm', "student");
		assertEquals(api.userIndex.size(), 1);
		assertEquals(api.userIndex.get(1l).getFirstName(), "Donal");
		api.addUser("Robbie", "Rotten", 35, 'm', "other");
		assertEquals(api.userIndex.size(), 2);
		assertEquals(api.userIndex.get(2l).getFirstName(), "Robbie");
	}

}
