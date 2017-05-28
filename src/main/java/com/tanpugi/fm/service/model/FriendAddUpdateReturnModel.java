package com.tanpugi.fm.service.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FriendAddUpdateReturnModel extends DefaultReturnModel {

	private Set<String> recipients = new HashSet<>();
	
	public Set<String> getRecipients() {
		return recipients;
	}
	
	public void addRecipients(Set<String> recipients) {
		this.recipients.addAll(recipients);
	}
	
	public void addRecipient(String recipient) {
		this.recipients.add(recipient);
	}
}
