package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchDbToCsvApplication {

	public static void main(String[] args) {
		System.out.println("In main1");
		SpringApplication.run(BatchDbToCsvApplication.class, args);
		System.out.println("In main2");
	}

}
