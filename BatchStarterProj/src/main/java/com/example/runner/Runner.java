package com.example.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	public Job job;
	@Autowired
	public JobLauncher jobLauncher;

	@Override
	public void run(String... args) throws Exception {
		JobParameters param= new JobParametersBuilder()
				.addLong("UID", (System.currentTimeMillis())).toJobParameters();
		System.out.println("In Runner");
		JobExecution launch=jobLauncher.run(job, param);
		
		System.out.println(launch.getExitStatus());
		System.out.println(launch.getStatus());

	}

}
