package io.undertree.goodbye

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(GoodbyeController.Companion.MAPPING)
class GoodbyeController(private val goodbyeRepository: GoodbyeRepository) {

    companion object {
        const val MAPPING = "/goodbye"
    }

    @GetMapping
    fun getAllPaged(page: Pageable): ResponseEntity<Page<GoodbyeEntity>> =
            ok(goodbyeRepository.findAll(page))

    @PostMapping
    fun addOne(@RequestBody goodbye: GoodbyeEntity): ResponseEntity<Void> {
        val aGoodbye = goodbyeRepository.save(goodbye)
        return created(URI.create("$MAPPING/${aGoodbye.id}")).build()
    }

    @GetMapping("{id}")
    fun getOneById(@PathVariable id: Long): ResponseEntity<GoodbyeEntity> =
            goodbyeRepository.findById(id)
                    .map {
                        ok(it)
                    }
                    .orElseGet {
                        notFound().build()
                    }

    @DeleteMapping("{id}")
    fun deleteOneById(@PathVariable id: Long): ResponseEntity<Void> =
            goodbyeRepository.findById(id)
                    .map {
                        goodbyeRepository.delete(it.id)
                        ok().build<Void>()
                    }
                    .orElseGet {
                        noContent().build()
                    }

    @GetMapping("/name/{name}")
    fun anyByName(@PathVariable name: String, page: Pageable): ResponseEntity<Page<GoodbyeEntity>> =
            ok(goodbyeRepository.findByName(name, page))
}
