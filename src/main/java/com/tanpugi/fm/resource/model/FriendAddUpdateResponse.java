package com.tanpugi.fm.resource.model;

import java.util.ArrayList;
import java.util.List;

public class FriendAddUpdateResponse extends DefaultResponse {

	private List<String> recipients = new ArrayList<String>();
	
	public List<String> getRecipients() {
		return recipients;
	}
	
	public void setRecipients(List<String> recipients) {
		this.recipients = recipients;
	}
}
