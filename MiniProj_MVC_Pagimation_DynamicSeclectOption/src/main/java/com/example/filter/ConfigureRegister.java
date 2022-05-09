package com.example.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Component
public class ConfigureRegister implements WebMvcConfigurer{
	
	@Autowired
	private LocaleChangeInterceptor loc;
	
	@Override
	public void addInterceptors(InterceptorRegistry reg) {
		System.out.println("In interceptor registry");
		reg.addInterceptor(new Interceptor_filter());
		reg.addInterceptor(loc);
	}

}
