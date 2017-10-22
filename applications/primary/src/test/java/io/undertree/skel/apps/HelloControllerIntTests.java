package io.undertree.skel.apps;

import io.undertree.hello.HelloController;
import io.undertree.hello.HelloRepository;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloController.class)
@ComponentScan({ "io.undertree.hello" })
public class HelloControllerIntTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private HelloRepository helloRepository;

	@Test
	public void test_Something() throws Exception {
		this.mvc.perform(get("/hello")
				.accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello!"));
	}
}
