package io.undertree.goodbye;

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
public class GoodbyeControllerTests {

    @Mock
    GoodbyeRepository goodbyeRepository;

    @Test
    public void given_GoodbyeController_WhenGoodbyeRepositoryFindByIdIs1_Then_ExpectOkRalph() throws Exception {
        when(goodbyeRepository.findById(1L))
                .thenReturn(Optional.of(new GoodbyeRecord(1L, "Ralph")));

        GoodbyeController controller = new GoodbyeController(goodbyeRepository);
        ResponseEntity<GoodbyeRecord> response = controller.goodbye(1L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(1L);
        assertThat(response.getBody().getName()).isEqualTo("Ralph");
    }
}
