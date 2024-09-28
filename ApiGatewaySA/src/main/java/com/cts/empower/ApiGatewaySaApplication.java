package com.cts.empower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.cts.empower.filter.AuthenticationFilter;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewaySaApplication {
	@Autowired
	AuthenticationFilter filter;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

		return builder.routes().route("userservice",
				p -> p.path("/api/v1/userprofile/**").uri("lb://USERPROFILESERVICE"))
				.route("skilldata",
						p -> p.path("/api/v1/skillset/**").filters(f -> f.filter(filter)).uri("lb://SKILLDATASERVICE"))
				.route("auth",
						p -> p.path("/api/auth/**").uri("lb://AUTHENTICATIONSERVICE"))
				.route("favourite",
						p -> p.path("/api/v1/favourite/**").filters(f -> f.filter(filter)).uri("lb://FAVOURITESERVICE"))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewaySaApplication.class, args);
	}

}
