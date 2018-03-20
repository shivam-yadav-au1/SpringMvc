package com.wheebox.beans;

public class User {
	
	private String username;
	private String email;
	private String phoneNumber;
	private String address;
	
	
	public User() {
		
	}

	public User(final String username,final String email,final String phoneNumber,final String address) {
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}


	public String getEmail() {
		return email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
