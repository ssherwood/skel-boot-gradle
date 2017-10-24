package io.undertree.hello;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({ "io.undertree.hello" })
@EnableJpaRepositories({ "io.undertree.hello" })
@EntityScan({ "io.undertree.hello" })
public class HelloConfig {
}
