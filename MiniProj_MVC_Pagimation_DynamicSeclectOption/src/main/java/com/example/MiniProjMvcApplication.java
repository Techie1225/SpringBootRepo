package com.example;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
//@PropertySource("classpath:/Validations.properties")
public class MiniProjMvcApplication {
	
	@Bean("messageSource")	//fixed bean id
	public ResourceBundleMessageSource baseMsg() {
		ResourceBundleMessageSource resourceBundleMessageSource=new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("com/example.prop/myfile");
		return resourceBundleMessageSource;
	}
	
	@Bean(name="localeResolver") //fixed bean id
	public SessionLocaleResolver createresover() {
		SessionLocaleResolver sessionLocaleResolver= new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		return sessionLocaleResolver;
	}
	
	
	@Bean
	public LocaleChangeInterceptor languageinterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");	//default is locale
		return localeChangeInterceptor;	
	}

	public static void main(String[] args) {
		SpringApplication.run(MiniProjMvcApplication.class, args);
	}

}
