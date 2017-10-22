package io.undertree.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	private final HelloRepository helloRepository;

	@Autowired
	public HelloController(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}

	@GetMapping("{id}")
	public ResponseEntity<HelloRecord> hello(@PathVariable Long id) {
		return helloRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
