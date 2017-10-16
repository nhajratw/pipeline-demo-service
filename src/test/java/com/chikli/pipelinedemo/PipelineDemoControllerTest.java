package com.chikli.pipelinedemo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class PipelineDemoControllerTest {

	@Test
	public void basicResponse() throws IOException {
		ResourceLoader resourceLoader = mock(ResourceLoader.class);
		Resource expectedResource = mock(Resource.class);
		when(resourceLoader.getResource("classpath:data.json")).thenReturn(expectedResource);
		PipelineDemoController controller = new PipelineDemoController(resourceLoader);
		assertThat(controller.cd(), is(expectedResource));
	}
}
