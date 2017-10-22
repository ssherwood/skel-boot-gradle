package io.undertree.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	private final HelloRepository helloRepository;

	@Autowired
	public HelloController(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello!";
	}
}
