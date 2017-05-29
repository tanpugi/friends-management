package com.tanpugi.fm;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.fakemongo.junit.FongoRule;
import com.mongodb.Mongo;

//@ActiveProfiles({ "test", "unit" })
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ApplicationConfigUnitTest.class })
public abstract class BaseTest {
}
