package models;

import java.util.HashMap;
import java.util.Map;

public class User {
	static Long counter = 0l;
	
	public Long id;
	public String firstName;
	public String lastName;
	public char gender;
	public int age;
	public String occupation;
	
	public Map<Long, Rating> ratings = new HashMap<>();
	
	public User(String firstName, String lastName, char gender, int age, String occupation)
	{
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
	}
	
	public User(Long id, String firstName, String lastName, char gender, int age, String occupation)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
	}
	
	public String toString()
	{
		return "ID= " + id + " Name= " + firstName + " " + lastName + " Gender= " + gender + " Age= " + age + " Occupation= " + occupation;
	}
}
