package com.tanpugi.fm.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FriendConnectionRepository extends MongoRepository<FriendConnection, String> {
	
	List<FriendConnection.PersonTo> findAllByPersonFrom(String personFrom);
	int countByPersonFromAndPersonTo(String personFrom, String personTo);
}
