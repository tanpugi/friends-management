package com.tanpugi.fm.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FollowerRepository extends MongoRepository<FollowerEntity, String> {
	
	List<String> findByFollowed(String followed);

}
