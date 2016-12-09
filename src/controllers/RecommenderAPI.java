package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Movie;
import models.Rating;
import models.Recommendation;
import models.User;
import utils.CSVLoader;

public class RecommenderAPI implements RecommenderInterface {
	
	Map<Long, User> userIndex;
	Map<Long, Movie> movieIndex;
	
	public RecommenderAPI(){
		userIndex = new HashMap<>();
		movieIndex = new HashMap<>();
	}

	@Override
	public void addUser(String firstName, String lastName, int age, char gender, String occupation) {
		User user = new User(firstName, lastName, gender, age, occupation);
		user.id = userIndex.size() + 1l;
		userIndex.put(user.id, user);

	}

	@Override
	public void removeUser(Long userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMovie(String title, String year, String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRating(Long userID, Long movieID, int rating) {
		// TODO Auto-generated method stub

	}

	@Override
	public Movie getMovie(Long movieID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Rating> getUserRatings(Long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Recommendation> getUserRecommendations(Long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Movie> getTopTenMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() throws Exception {
		CSVLoader loader = new CSVLoader();
		//Loads users from Data
		List<User> users = loader.loadUsers("Data/users5.dat");
		for (User user : users)
		{
			userIndex.put(user.id, user);
		}
		//Loads Movies from Data
		List<Movie> movies = loader.loadMovies("Data/items5.dat");
		for (Movie movie : movies)
		{
			movieIndex.put(movie.id, movie);
		}

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub

	}

}
