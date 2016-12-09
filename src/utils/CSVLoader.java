package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import models.Movie;
import models.Rating;
import models.User;

import in;

public class CSVLoader {
	
	public List<User> loadUsers(String filename) throws Exception
	{
		File usersFile = new File(filename);
		In inUsers = new In(usersFile);
	
		
		String delims = "[|]";
		List<User> users = new ArrayList<User>();
		while(!inUsers.isEmpty())
		{
			String userDetails = inUsers.readLine();
			String[] userTokens = userDetails.split(delims);
			if (userTokens.length == 7)
			{
				String id			= userTokens[0];
				String firstName	= userTokens[1];
				String lastName		= userTokens[2];
				String age			= userTokens[3];
				String gender		= userTokens[4];
				String occupation	= userTokens[6];
				
				users.add(new User(firstName, lastName, gender, age, occupation));
			}
				
			else
			{
				throw new Exception("Invalid member length: " + userTokens.length);
			}
		}
		return users;
	}
	
	public List<Movie> loadMovies(String filename) throws Exception
	{
		return null;
	}
	
	public List<Rating> loadRatings(String filename) throws Exception
	{
		return null;
	}

}
