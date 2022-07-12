package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BatchDbToCsvApplication {

	public static void main(String[] args) {
		System.out.println("In main1");
		SpringApplication.run(BatchDbToCsvApplication.class, args);
		System.out.println("In main2");
	}

}
