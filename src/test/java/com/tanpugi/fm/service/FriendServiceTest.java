package com.tanpugi.fm.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.github.fakemongo.junit.FongoRule;
import com.tanpugi.fm.BaseTest;
import com.tanpugi.fm.service.model.DefaultReturnModel;
import com.tanpugi.fm.service.model.FriendAddUpdateReturnModel;
import com.tanpugi.fm.service.model.FriendListReturnModel;
import com.tanpugi.fm.service.model.ReturnCode;

public class FriendServiceTest extends BaseTest {
	
	@Autowired
	private FriendService service;
	

	
	@Test
	public void testAddConnection() {
		DefaultReturnModel rm = service.addConnection("john@email.com", "andy@email.com");
		assertThat(rm).isNotNull();
		assertThat(rm.getReturnCode()).isEqualTo(ReturnCode.OK);
		
		rm = service.addConnection("john@email.com", "xxx@email.com");
		assertThat(rm).isNotNull();
		assertThat(rm.getReturnCode()).isEqualTo(ReturnCode.OK);
		
		rm = service.addConnection("andy@email.com", "xxx@email.com");
		assertThat(rm).isNotNull();
		assertThat(rm.getReturnCode()).isEqualTo(ReturnCode.OK);
	}
	
	@Test
	public void testListConnections() {
		testAddConnection();
		FriendListReturnModel rm = service.listCommonConnections("john@email.com", "andy@email.com");
		assertThat(rm).isNotNull();
		assertThat(rm.getConnections()).isNotEmpty();
		assertThat(rm.getConnections().get(0)).isEqualTo("xxx@email.com");
	}
	
	@Test
	public void testFollow() {
		DefaultReturnModel rm = service.follow("andy@email.com", "kate@email.com");
		assertThat(rm).isNotNull();
		assertThat(rm.getReturnCode()).isEqualTo(ReturnCode.OK);
	}
	
	@Test
	public void testUnfollow() {
		testFollow();
		DefaultReturnModel rm = service.unfollow("andy@email.com", "kate@email.com");
		assertThat(rm).isNotNull();
		assertThat(rm.getReturnCode()).isEqualTo(ReturnCode.OK);
	}
	
	@Test
	public void testAddUpdate() {
		testAddConnection();
		testFollow();
		FriendAddUpdateReturnModel rm = service.addUpdate("andy@email.com", "Text lisa@email.com");
		assertThat(rm).isNotNull();
		assertThat(rm.getRecipients()).isNotEmpty();
		assertThat(rm.getRecipients()).containsExactlyInAnyOrder("xxx@email.com","kate@email.com","lisa@email.com","john@email.com");
	}
	
}
