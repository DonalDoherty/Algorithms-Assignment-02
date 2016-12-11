package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Movie;
import models.Rating;
import models.User;
import utils.CSVLoader;
import utils.DataSerializer;

public class RecommenderAPI implements RecommenderInterface {
	
	Map<Long, User> userIndex;
	Map<Long, Movie> movieIndex;
	List<Rating> ratingIndex;
	DataSerializer serializer;
	File data;

	public RecommenderAPI() throws Exception{
		userIndex = new HashMap<>();
		movieIndex = new HashMap<>();
		ratingIndex = new ArrayList<>();
		data = new File("data.xml");
		serializer = new DataSerializer(data);
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
		userIndex.get(userID).getRatings().add(new Rating(userID, movieID, rating));
		movieIndex.get(movieID).getRatings().add(new Rating(userID, movieID, rating));
		movieIndex.get(movieID).computeRating();
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
	//nonfucntional
	public List<Movie> getUserRecommendations(Long userID) {
		getTopTenMovies();
		ArrayList<Movie> recommendations = new ArrayList<Movie>();
		
			for(Long i = 1l; i<movieIndex.size(); i++)
			{
				for(int j = 1; j<userIndex.get(userID).getRatings().size(); j++)
				{
				if(movieIndex.get(i).getAvg() != 0 && movieIndex.get(i).getId() != userIndex.get(userID).getRatings().get(j).getMovieID())
				{
					recommendations.add(movieIndex.get(i));
				}
			}
		}
		Collections.sort(recommendations);
		return recommendations.subList(0, 10);
	}

	@Override
	public List<Movie> getTopTenMovies() {
		ArrayList<Movie> avgSort = new ArrayList<Movie>();
		for(Long i = 1l; i<movieIndex.size(); i++)
		{
			if(movieIndex.get(i).getAvg() != 0)
			{
				avgSort.add(movieIndex.get(i));
			}
		}
		Collections.sort(avgSort);
		return avgSort.subList(0, 10);
	}

	@SuppressWarnings("unchecked")
	@Override
	//
	public void load() throws Exception 
	{
//		if (data.isFile())
//		{
//			serializer.read();
//			ratingIndex = (ArrayList<Rating>) serializer.pop();
//			movieIndex = (Map<Long, Movie>) serializer.pop();
//			userIndex = (Map<Long, User>) serializer.pop();
//		}
//		
//		else{
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
//		}
	}


	@Override
	public void write() throws Exception {
		serializer.push(userIndex);
		serializer.push(movieIndex);
		serializer.push(ratingIndex);
		serializer.write();
	}

}
