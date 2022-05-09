package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class SpringMvcMultipart1Application {

	/*
	 * @Bean public ViewResolver configResolver() { InternalResourceViewResolver
	 * resolver= new InternalResourceViewResolver();
	 * resolver.setPrefix("WEB-INF/pages/"); resolver.setSuffix(".jsp"); return
	 * resolver; }
	 */
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createCMResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(50 * 1024 * 1024);
		resolver.setMaxUploadSize(-1); // all files togather how much size is allowed -1 indicates no limit
		return resolver;
	}

	@Bean
public ViewResolver reportGeneration()
	{
		BeanNameViewResolver resolver1=new BeanNameViewResolver();
		resolver1.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return resolver1;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcMultipart1Application.class, args);
	}

}
