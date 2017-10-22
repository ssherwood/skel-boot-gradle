package io.undertree.hello;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTests {

	@Mock
	HelloRepository helloRepository;

	@Test
	public void given_HelloController_WhenHelloRepositoryFindByIdIs1_Then_ExpectOkRalph() throws Exception {
		when(helloRepository.findById(1L))
				.thenReturn(Optional.of(new HelloRecord(1L, "Ralph")));

		HelloController controller = new HelloController(helloRepository);
		ResponseEntity<HelloRecord> response = controller.hello(1L);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
		assertThat(response.getBody().getId()).isEqualTo(1L);
		assertThat(response.getBody().getName()).isEqualTo("Ralph");
	}
}
