package com.chikli.pipelinedemo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PipelineDemoControllerTest {

	@Test
	public void basicResponse() {
		PipelineDemoController controller = new PipelineDemoController();
		assertThat(controller.cd(), is("{\"topic\": \"Building a Continuous Deployment Pipeline from Scratch\", \"presenter\": \"Nayan Hajratwala\"}"));
	}
}
