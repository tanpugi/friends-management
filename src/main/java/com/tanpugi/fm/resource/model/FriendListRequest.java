package com.tanpugi.fm.resource.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class FriendListRequest {

	@NotNull @Email
	private String email;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String user) {
		this.email = user;
	}
}
