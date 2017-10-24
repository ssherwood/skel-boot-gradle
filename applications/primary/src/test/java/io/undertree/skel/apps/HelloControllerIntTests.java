package io.undertree.skel.apps;

import java.util.Optional;

import io.undertree.hello.HelloConfig;
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
import static org.springframework.context.annotation.ComponentScan.Filter;
import static org.springframework.context.annotation.FilterType.ASSIGNABLE_TYPE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * NOTES:
 *
 * We need to scan the "io.undertree.hello" component package manually to pick
 * up the required controller slice or it will not be found since it lives
 * outside the Spring Boot application namespace (e.g. you will get a 404).
 * However, you need to exclude the HelloConfig during that scan or else the
 * slice will attempt to wire up JPA and will fail...
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloController.class)
@ComponentScan(value = {"io.undertree.hello"},
        excludeFilters = {@Filter(type = ASSIGNABLE_TYPE, value = HelloConfig.class)})
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
