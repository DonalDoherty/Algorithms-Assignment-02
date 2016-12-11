package models;


import java.util.ArrayList;


public class User {
	static Long counter = 0l;
	
	private Long id;
	private String firstName;
	private String lastName;
	private char gender;
	private int age;
	private String occupation;
	
	private ArrayList<Rating> ratings;
	
	public User(String firstName, String lastName, char gender, int age, String occupation)
	{
		this.ratings = new ArrayList<Rating>();
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
	}
	
	public User(Long id, String firstName, String lastName, char gender, int age, String occupation)
	{
		this.ratings = new ArrayList<Rating>();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public ArrayList<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}
}
