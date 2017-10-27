package io.undertree.goodbye

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.anyLong
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import org.springframework.http.HttpStatus
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class GoodbyeControllerTests {

    @Mock
    lateinit var goodbyeRepository: GoodbyeRepository

    @Test
    fun `Should expect 200 and body containing id and name`() {

        given(goodbyeRepository.findById(1L))
                .willReturn(Optional.of(GoodbyeEntity(1L, "Ralph")))

        val controller = GoodbyeController(goodbyeRepository)
        val response = controller.oneById(1L)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).isNotNull()
        assertThat(response.body.id).isEqualTo(1L)
        assertThat(response.body.name).isEqualTo("Ralph")
    }

    @Test
    fun `Should expect 404`() {

        given(goodbyeRepository.findById(anyLong()))
                .willReturn(Optional.empty())

        val controller = GoodbyeController(goodbyeRepository)
        val response = controller.oneById(1L)

        assertThat(response.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }
}
