package io.undertree.skel.apps.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories({ "io.undertree.hello" })
@EntityScan({ "io.undertree.hello" })
@ComponentScan({ "io.undertree.hello" })
public class JpaConfig {
}
