package com.cts.empower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class UserProfileserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileserviceApplication.class, args);
	}

}
