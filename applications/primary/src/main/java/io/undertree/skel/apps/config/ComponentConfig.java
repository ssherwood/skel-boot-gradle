package io.undertree.skel.apps.config;

import io.undertree.goodbye.EnableGoodbyeComponent;
import io.undertree.hello.EnableHelloComonent;

import org.springframework.context.annotation.Configuration;

/**
 * Use this configuration to enable components
 */
@Configuration
@EnableHelloComonent
@EnableGoodbyeComponent
public class ComponentConfig {
    // fyi - this config is not on the PrimaryApp config since the Spring Boot
    // "slice" tests activate the main app and we don't want the whole
    // component to be wired up in some cases (specifically, JPA repositories)
    // since we get the error:
    // Caused by: java.lang.IllegalArgumentException: At least one JPA metamodel must
    // be present!
}
