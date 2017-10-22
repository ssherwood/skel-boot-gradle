package io.undertree.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<HelloRecord, Long> {
	HelloRecord findById(Long id);
}
