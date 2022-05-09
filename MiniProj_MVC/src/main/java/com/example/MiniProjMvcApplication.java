package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:/Validations.properties")
public class MiniProjMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjMvcApplication.class, args);
	}

}
