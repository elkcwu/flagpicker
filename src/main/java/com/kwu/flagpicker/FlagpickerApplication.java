package com.kwu.flagpicker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCaching
@EnableCircuitBreaker
public class FlagpickerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlagpickerApplication.class, args);
	}

}
