package com.example.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class Interceptor_filter implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object halderObj) throws ServletException, IOException {
		System.out.println("In preHandle()");
		LocalDateTime time = LocalDateTime.now();
		Integer ti=time.getHour();
	//	System.out.println(ti);
		if(ti<9 && ti>18) {
			System.out.println("_________");
			RequestDispatcher rd= req.getRequestDispatcher("/TradeTiming.jsp");
			rd.forward(req, res);
			return false;
		}
		return true;
			}
}


