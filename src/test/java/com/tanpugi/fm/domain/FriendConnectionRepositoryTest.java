package com.tanpugi.fm.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tanpugi.fm.BaseTest;

import java.util.List;

public class FriendConnectionRepositoryTest extends BaseTest {
	
	@Autowired
	private FriendConnectionRepository repository;
	
	@Test
	public void testSave() {
		FriendConnection fc = new FriendConnection();
		fc.setPersonFrom("from@email.com");
		fc.setPersonTo("to@email.com");
		
		fc = repository.save(fc);
		assertThat(fc).isNotNull();
		assertThat(fc.getId()).isNotNull();
		assertThat(fc.getPersonFrom()).isEqualTo("from@email.com");
	}
	
	@Test
	public void testFindAll() {
		testSave();
		List<FriendConnection.PersonTo> fcs = repository.findAllByPersonFrom("from@email.com");
		assertThat(fcs).isNotEmpty();
	}
}
