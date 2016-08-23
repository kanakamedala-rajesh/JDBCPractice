package com.jdbc.practice;

public class Person {

	private int id;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;

	public Person() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
		//System.out.println(FirstName);
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
		//System.out.println(LastName);
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
		//System.out.println(Email);
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
		//System.out.println(Phone);
	}

}
