package com.usermanagment.bean;

import java.io.Serializable;


public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String gender;
	private String email;
	private String password;
	private String country;
	
	public User(String name, String gender, String email, String password, String country) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.country = country;
	}

	public User(int id, String name, String gender, String email, String password, String country) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.country = country;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
