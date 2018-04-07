package io.undertree.goodbye

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GoodbyeRepository : JpaRepository<GoodbyeEntity, Long> {
    // trying to use Java Optional
    fun findById(id: Long): Optional<GoodbyeEntity>

    // trying to use just null
    fun findByName(name: String, page: Pageable): Page<GoodbyeEntity>
}
