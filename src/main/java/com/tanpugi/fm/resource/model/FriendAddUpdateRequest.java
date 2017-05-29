package com.tanpugi.fm.resource.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class FriendAddUpdateRequest {

	@NotNull @Email
	private String sender;
	@NotNull
	private String text;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
