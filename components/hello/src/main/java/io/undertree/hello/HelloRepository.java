package io.undertree.hello;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<HelloRecord, Long> {
	Optional<HelloRecord> findById(Long id);
}
