package io.undertree.goodbye

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackageClasses = arrayOf(GoodbyeEntity::class))
@EnableJpaRepositories(basePackageClasses = arrayOf(GoodbyeRepository::class))
@ComponentScan(basePackageClasses = arrayOf(GoodbyeController::class))
internal class GoodbyeConfig
