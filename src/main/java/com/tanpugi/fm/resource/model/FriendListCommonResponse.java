package com.tanpugi.fm.resource.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tanpugi.fm.ApplicationDefaultResponse;

public class FriendListCommonResponse extends ApplicationDefaultResponse {
	@JsonInclude(value=Include.NON_NULL)
	private List<String> friends;
	
	public List<String> getFriends() {
		return friends;
	}
	
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	
	public int getCount() {
		return friends.size();
	}
}
