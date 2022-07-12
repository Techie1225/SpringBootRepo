package com.example.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Runner implements CommandLineRunner {

	@Autowired
	public Job job;
	@Autowired
	public JobLauncher jobLauncher; 
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("IN runner");
		JobParameters param=new JobParametersBuilder()
				.addLong("unique", System.currentTimeMillis())
				.toJobParameters();
		JobExecution exe=jobLauncher.run(job,param);
System.out.println(exe.getExitStatus());
	}

}
