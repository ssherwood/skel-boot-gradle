package io.undertree.goodbye;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodbyeRepository extends JpaRepository<GoodbyeRecord, Long> {
    Optional<GoodbyeRecord> findById(Long id);
}
