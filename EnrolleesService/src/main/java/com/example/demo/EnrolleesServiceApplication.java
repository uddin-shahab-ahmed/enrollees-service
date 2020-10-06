package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EnrolleesServiceApplication {

	private static final Logger LOGGER = LogManager.getLogger(EnrolleesServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("EnrolleesServiceApplication starting");
		SpringApplication.run(EnrolleesServiceApplication.class, args);
		LOGGER.info("EnrolleesServiceApplication started");
	}

}
