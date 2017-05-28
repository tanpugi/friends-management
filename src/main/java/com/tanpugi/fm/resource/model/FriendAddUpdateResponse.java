package com.tanpugi.fm.resource.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class FriendAddUpdateResponse extends DefaultResponse {

	@JsonInclude(value=Include.NON_NULL)
	private Set<String> recipients;
	
	public Set<String> getRecipients() {
		return recipients;
	}
	
	public void setRecipients(Set<String> recipients) {
		this.recipients = recipients;
	}
}
