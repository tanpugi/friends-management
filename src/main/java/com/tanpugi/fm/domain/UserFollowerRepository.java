package com.tanpugi.fm.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserFollowerRepository extends MongoRepository<UserFollower, String> {
	
	List<String> findByFollowed(String followed);

}
