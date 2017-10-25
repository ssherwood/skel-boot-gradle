package io.undertree.goodbye

import org.springframework.http.ResponseEntity.notFound
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/goodbye")
class GoodbyeController(private val goodbyeRepository: GoodbyeRepository) {

    @GetMapping("{id}")
    fun goodbye(@PathVariable id: Long) =
            goodbyeRepository.findById(id)
                    .map { ok(it) }
                    .orElseGet { notFound().build() }
}
