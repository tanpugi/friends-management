package com.tanpugi.fm.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Subscription {

	public static class Follower {
		private String follower;
		
		public String getFollower() {
			return follower;
		}
		
		public void setFollower(String follower) {
			this.follower = follower;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Follower) {
				Follower that = (Follower) obj;
				return this.getFollower().equals(that.getFollower());
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
			return 54 + this.getFollower().hashCode();
		}
	}
	@Id
	private String id;
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
