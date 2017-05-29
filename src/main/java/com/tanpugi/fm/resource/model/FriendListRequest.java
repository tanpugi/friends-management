package com.tanpugi.fm.resource.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class FriendListRequest {

	@NotNull @Email
	private String user;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
}
