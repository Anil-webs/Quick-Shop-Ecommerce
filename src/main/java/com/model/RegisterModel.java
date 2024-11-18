package com.model;

public class RegisterModel {
	private String firstname;
	private String username;
	private String password;

	
	public RegisterModel(){
		
	}
	public RegisterModel(String firstname, String username, String password){
		this.firstname = firstname;
		this.username = username;
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "firstname=" + firstname + ", username=" + username + ", password=" + password;
	}
	
	
	
}
