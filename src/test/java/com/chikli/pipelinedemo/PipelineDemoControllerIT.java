package com.chikli.pipelinedemo;

import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@Category(IntegrationTests.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PipelineDemoConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
public class PipelineDemoControllerIT {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@SuppressWarnings("rawtypes")
	private ResponseEntity<Map> entity;

	@Before
	public void setup() {
		entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/cd", Map.class);

	}

	@Test
	public void returns200() {
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void responseIsCorrect() {
		assertThat(entity.getBody().get("topic"), is("Building a Continuous Deployment Pipeline from Scratch"));
		assertThat(entity.getBody().get("presenter"), is("Nayan Hajratwala"));
	}
}
