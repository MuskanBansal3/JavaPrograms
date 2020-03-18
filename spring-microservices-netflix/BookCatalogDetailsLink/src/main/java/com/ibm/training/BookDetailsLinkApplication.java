package com.ibm.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker

public class BookDetailsLinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookDetailsLinkApplication.class, args);
	}
	
	@Bean // it creates objects for us automatically
	@LoadBalanced  // to tell we have used another name in url 
	RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}

