package com.tanpugi.fm.resource.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class FriendFollowRequest {

	@NotNull @Email
	private String requestor;
	@NotNull @Email
	private String target;

	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
}
