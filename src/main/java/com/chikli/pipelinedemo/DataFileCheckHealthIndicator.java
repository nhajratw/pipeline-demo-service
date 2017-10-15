package com.chikli.pipelinedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class DataFileCheckHealthIndicator implements HealthIndicator {

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Override
	public Health health() {
		Resource resource = resourceLoader.getResource("classpath:data.json");
		return resource.exists()
				? Health.up().build()
				: Health.down().withDetail("file", "data.json does not exist on the classpath").build();
	}

}
