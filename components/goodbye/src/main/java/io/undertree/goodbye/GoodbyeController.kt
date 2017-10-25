package io.undertree.goodbye

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.notFound
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/goodbye")
class GoodbyeController(private val goodbyeRepository: GoodbyeRepository) {

    @GetMapping
    fun allByPage(page: Pageable): ResponseEntity<Page<GoodbyeEntity>> =
            ok(goodbyeRepository.findAll(page))

    @GetMapping("{id}")
    fun oneById(@PathVariable id: Long): ResponseEntity<GoodbyeEntity> =
            goodbyeRepository.findById(id)
                    .map { ok(it) }
                    .orElseGet { notFound().build() }

    @GetMapping("/name/{name}")
    fun anyByName(@PathVariable name: String, page: Pageable): ResponseEntity<Page<GoodbyeEntity>> =
            ok(goodbyeRepository.findByName(name, page))
}
