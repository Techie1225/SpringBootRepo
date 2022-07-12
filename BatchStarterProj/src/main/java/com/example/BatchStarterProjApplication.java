package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchStarterProjApplication {

	public static void main(String[] args) {
		System.out.println("Application Initiated");
		SpringApplication.run(BatchStarterProjApplication.class, args);
		System.out.println("Application terminated");
	}

}
