package com.tanpugi.fm.resource.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FriendListCommonRequest {

	@NotNull @Size(min=2,max=2)
	private List<String> friends;
	
	public List<String> getFriends() {
		return friends;
	}
	
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
}
