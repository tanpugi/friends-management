package com.tanpugi.fm.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tanpugi.fm.BaseTest;

public class UpdateRepositoryTest extends BaseTest {

	@Autowired
	private UpdateRepository repository;
	
	@Test
	public void testSave() {
		Update s = new Update();
		s.setSender("sender@email.com");
		s.setText("The quick brown fox.");
		
		s = repository.save(s);
		
		assertThat(s).isNotNull();
		assertThat(s.getId()).isNotNull();
		assertThat(s.getSender()).isEqualTo("sender@email.com");
	}
	
	@Test
	public void testFindAllByFollowed() {
		testSave();
		List<Update> us = repository.findAll();
		
		assertThat(us).isNotEmpty();
	}
}
