package com.tanpugi.fm.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FriendConnection {

	public static class PersonTo {
		private String personTo;
		
		public String getPersonTo() {
			return personTo;
		}
		
		public void setPersonTo(String personTo) {
			this.personTo = personTo;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof PersonTo) {
				PersonTo that = (PersonTo) obj;
				return (this.getPersonTo().equalsIgnoreCase(that.getPersonTo()));
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return 53 + this.personTo.hashCode();
		}
	}

	@Id
	private String id;
	@Indexed
	private String personFrom;
	@Indexed
	private String personTo;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPersonFrom() {
		return personFrom;
	}
	public void setPersonFrom(String personFrom) {
		this.personFrom = personFrom;
	}
	public String getPersonTo() {
		return personTo;
	}
	public void setPersonTo(String personTo) {
		this.personTo = personTo;
	}
	
	
	
	
	
}
