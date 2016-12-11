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
	List<Rating> ratingIndex;

	public RecommenderAPI() throws Exception{
		userIndex = new HashMap<>();
		movieIndex = new HashMap<>();
		ratingIndex = new ArrayList<>();
	}

	@Override
	public void addUser(String firstName, String lastName, int age, char gender, String occupation) {
		User user = new User(firstName, lastName, gender, age, occupation);
		user.setId(userIndex.size() + 1l);
		userIndex.put(user.getId(), user);

	}

	@Override
	public void removeUser(Long userID) {
		userIndex.remove(userID);
	}

	@Override
	public void addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movie.setId(movieIndex.size() +1l);
		movieIndex.put(movie.getId(), movie);
	}

	@Override
	public void addRating(Long userID, Long movieID, int rating) {
		ratingIndex.add(new Rating(userID, movieID, rating));
	}

	@Override
	public Movie getMovie(Long movieID) {
		return movieIndex.get(movieID);
	}

	@Override
	public ArrayList<Rating> getUserRatings(Long userID) {
		return userIndex.get(userID).getRatings();
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
		List<User> users = loader.loadUsers("Data/users.dat");
		for (User user : users)
		{
			userIndex.put(user.getId(), user);
		}
		//Loads Movies from Data
		List<Movie> movies = loader.loadMovies("Data/items.dat");
		for (Movie movie : movies)
		{
			movieIndex.put(movie.getId(), movie);
		}
		//Loads Ratings from Data
		List<Rating> ratings = loader.loadRatings("Data/ratings.dat");
		for (Rating rating : ratings)
		{
			for (User user : users)
			{
				if(user.getId() == rating.getUserID())
				{
					user.getRatings().add(rating);
				}
			}
			for (Movie movie : movies)
			{
				if(movie.getId() == rating.getMovieID())
				{
					movie.getRatings().add(rating); 
				}
				movie.computeRating();
			}
			ratingIndex.add(rating);
		}

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub

	}

}
