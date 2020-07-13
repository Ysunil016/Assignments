package com.Spring.Bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Document(collection = "userLogins")
public class User {

	@Id
	@NotNull(message = "Please Provide Username")
	@Email
	private String username;
	@NotNull(message = "Please Provide Password")
	private String password;

//By Default User Will be Client
	private String role = "ROLE_CLIENT";

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
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public String getRole() {
		return role;
	}

//	public void setRole(String role) {
//		this.role = role;
//	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
