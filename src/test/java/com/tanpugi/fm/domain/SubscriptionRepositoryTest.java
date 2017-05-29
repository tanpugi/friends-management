package com.tanpugi.fm.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tanpugi.fm.BaseTest;

public class SubscriptionRepositoryTest extends BaseTest {

	@Autowired
	private SubscriptionRepository repository;
	
	@Test
	public void testSave() {
		Subscription s = new Subscription();
		s.setFollowed("followed@email.com");
		s.setFollower("follower@email.com");
		
		s = repository.save(s);
		
		assertThat(s).isNotNull();
		assertThat(s.getId()).isNotNull();
		assertThat(s.getFollower()).isEqualTo("follower@email.com");
	}
	
	@Test
	public void testFindAllByFollowed() {
		testSave();
		Set<Subscription.Follower> fs = repository.findAllByFollowed("followed@email.com");
		
		assertThat(fs).isNotEmpty();
	}
}
