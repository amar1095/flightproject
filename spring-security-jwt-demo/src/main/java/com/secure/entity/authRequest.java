package com.secure.entity;

public class authRequest {

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public authRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public authRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
