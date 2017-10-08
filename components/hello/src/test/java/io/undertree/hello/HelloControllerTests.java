package io.undertree.hello;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTests {

	@Test
	public void testHello() throws Exception {
		HelloController controller = new HelloController();
		assertThat(controller.hello()).isSameAs("Hello!");
	}
}
