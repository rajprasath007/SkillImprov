package com.skillImprov.dto;

import com.skillImprov.enums.Role;

public class RegisterDTO {
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private Role role;

	public RegisterDTO(String userName, String email, String password, Role role) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public RegisterDTO() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegistorDTO [userName=" + userName + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
	
}
