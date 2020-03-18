package com.ibm.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookDetailsEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookDetailsEurekaServerApplication.class, args);
	}

}
