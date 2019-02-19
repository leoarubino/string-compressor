package com.stringcompressor.app;

public class Candidate {
	private String lastName;
	private String name;
	private String id;

	public Candidate(String lastName, String name, String id) {
		this.lastName = lastName;
		this.name = name;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}
}
