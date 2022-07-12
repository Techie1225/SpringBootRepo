package com.example.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("listener")
public class BatchListener implements JobExecutionListener {

	@Override
	 public void beforeJob(JobExecution jobExecution) {
		System.out.println("Start Time :: "+new Date());
		}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Stop Time :: "+System.currentTimeMillis());
		System.out.println("Job Status :: "+jobExecution.getStatus());
		System.out.println("Job Exit Status :: "+jobExecution.getExitStatus());
		}

	
}
