package com.tanpugi.fm.domain;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
	
	Set<Subscription.Follower> findAllByFollowed(String followed);
	int countByFollowedAndFollower(String followed, String follower);
}
