package com.stringcompressor.entity;

public class Candidate {
	private String lastName;
	private String firstName;
	private String id;

	public Candidate(String lastName, String firstName, String id) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
