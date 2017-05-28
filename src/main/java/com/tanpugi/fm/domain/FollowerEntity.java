package com.tanpugi.fm.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;

@Entity
public class FollowerEntity {

	@Id
	private String id;
	@Indexed
	private String followed;
	private String follower;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getFollowed() {
		return followed;
	}
	
	public void setFollowed(String followed) {
		this.followed = followed;
	}
	
	public String getFollower() {
		return follower;
	}
	
	public void setFollower(String follower) {
		this.follower = follower;
	}
}
