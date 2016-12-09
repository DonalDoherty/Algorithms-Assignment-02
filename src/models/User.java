package models;

import java.util.HashMap;
import java.util.Map;

public class User {
	static Long counter = 0l;
	
	public Long id;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public String gender;
	public String age;
	public String occupation;
	
	public Map<Long, Rating> ratings = new HashMap<>();
	public Map<Long, Recommendation> recommendations = new HashMap<>();
	
	public User(String firstName, String lastName, String gender, String age, String occupation)
	{
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
	}
	
	public User(Long id, String firstName, String lastName, String gender, String age, String occupation)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
	}
}
