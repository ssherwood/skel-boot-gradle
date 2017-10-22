package io.undertree.hello;

import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTests {

	@Mock
	HelloRepository helloRepository;

	@Test
	public void testHello() throws Exception {
		HelloController controller = new HelloController(helloRepository);
		assertThat(controller.hello()).isSameAs("Hello!");
	}
}
