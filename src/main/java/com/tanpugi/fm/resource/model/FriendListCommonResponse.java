package com.tanpugi.fm.resource.model;

import java.util.ArrayList;
import java.util.List;

public class FriendListCommonResponse extends DefaultResponse {
	private List<String> friends = new ArrayList<>();
	
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
