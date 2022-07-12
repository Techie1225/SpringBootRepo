package com.example.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class Runner{

	@Autowired
	public Job job;
	@Autowired
	public JobLauncher jobLauncher; 
	
	
	@Scheduled(cron="0/50 * * * * *")
	public void run() throws Exception {
		System.out.println("IN runner");
		JobParameters param=new JobParametersBuilder()
				.addLong("unique", System.currentTimeMillis())
				.toJobParameters();
		JobExecution exe=jobLauncher.run(job,param);
System.out.println(exe.getExitStatus());
	}

}
