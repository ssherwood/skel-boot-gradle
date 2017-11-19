package io.undertree.skel.apps.config;

import java.util.Collections;

import org.jetbrains.annotations.NotNull;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				// would like to find a more elegant solution to this...
				.apis(RequestHandlerSelectors.basePackage("io.undertree"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
	}

	@NotNull
	private ApiInfo metaData() {
		return new ApiInfo(
				"Spring Boot REST API",
				"Spring Boot REST API for Greetings",
				"1.0",
				"http://termsofservice.com",
				new Contact("Shawn Sherwood", "http://undertree.io/", "shawn.sherwood@undertree.io"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0",
				Collections.emptyList());
	}
}
