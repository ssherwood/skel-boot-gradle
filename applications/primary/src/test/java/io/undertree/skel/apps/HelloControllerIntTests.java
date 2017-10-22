package io.undertree.skel.apps;

import java.util.Optional;

import io.undertree.hello.HelloController;
import io.undertree.hello.HelloRecord;
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

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
	public void test_HelloController_WhenHelloRepositoryFindByIdIs1_Then_ExpectRalphOk() throws Exception {
		when(helloRepository.findById(1L))
				.thenReturn(Optional.of(new HelloRecord(1L, "Ralph")));

		this.mvc.perform(get("/hello/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.name", is("Ralph")));
	}
}
