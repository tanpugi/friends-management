package com.tanpugi.fm;

import java.util.UUID;

import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.github.fakemongo.junit.FongoRule;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.tanpugi.fm.service.FriendService;
import com.tanpugi.fm.service.FriendServiceImpl;

@Configuration
@EnableMongoRepositories
public class ApplicationConfigUnitTest extends AbstractMongoConfiguration {
	
	private static String dbName = "fakemongo"+UUID.randomUUID();
	@Bean
	public FriendService getFriendService() {
		return new FriendServiceImpl();
	};
	
    @Override
    protected String getDatabaseName() {
    	return dbName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo(getDatabaseName()).getMongo();
    }
    
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(new MongoClient("localhost"), getDatabaseName());
	}
}
