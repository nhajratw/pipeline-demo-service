package com.chikli.pipelinedemo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@RunWith(MockitoJUnitRunner.class)
public class PipelineDemoControllerTest {
	@Mock
	private ResourceLoader resourceLoader;

	@Mock
	private Resource expectedResource;

	@Test
	public void basicResponse() {
		when(resourceLoader.getResource("classpath:data.json")).thenReturn(expectedResource);
		PipelineDemoController controller = new PipelineDemoController(resourceLoader);
		assertThat(controller.cd(), is(expectedResource));
	}
}
