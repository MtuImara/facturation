package com.obr.facturation.request;

import javax.validation.constraints.NotEmpty;

public class LoginRequest {

	@NotEmpty(message = "User name cannot be empty")
	private String username;

	@NotEmpty(message = "User name cannot be empty")
	private String password;

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

}
