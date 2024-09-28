package com.cts.empower.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
	 @Bean
	    public GroupedOpenApi publicApi() {
	        return GroupedOpenApi.builder()
	                .group("public")
	                .pathsToMatch("/api/**")
	                .build();
	    }

	    @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .info(new Info().title("Spring Boot API")
	                .version("1.0")
	                .description("API documentation for Spring Boot application"));
	    }
}
