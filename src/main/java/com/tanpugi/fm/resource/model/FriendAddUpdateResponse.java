package com.tanpugi.fm.resource.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tanpugi.fm.ApplicationDefaultResponse;

public class FriendAddUpdateResponse extends ApplicationDefaultResponse {

	@JsonInclude(value=Include.NON_NULL)
	private Set<String> recipients;
	
	public Set<String> getRecipients() {
		return recipients;
	}
	
	public void setRecipients(Set<String> recipients) {
		this.recipients = recipients;
	}
}
