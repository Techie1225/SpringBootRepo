package com.example.report;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("report")
public class SchedReport {

	@Scheduled(cron="* * * 1W * *")
	public void meth() {
		System.out.println(new Date());		
	}
}
