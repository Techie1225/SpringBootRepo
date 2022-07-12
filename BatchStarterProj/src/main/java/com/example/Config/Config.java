package com.example.Config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.BatchProcessor.Processor;
import com.example.BatchReader.Reader;
import com.example.BatchWriter.Writer;
import com.example.listener.BatchListener;

@Configuration
@EnableBatchProcessing

public class Config{
	@Autowired
	public JobBuilderFactory jobFactory;
	
	@Autowired
	public StepBuilderFactory stepFactory;

	@Autowired
	public BatchListener listener;

	@Autowired
	public Reader reader;

	@Autowired
	public Processor processor;
	
	@Autowired
	public Writer writer;
	
	@Bean(name="step")
	public Step createStep(){
		return stepFactory.get("step")
				.<String,String>chunk(3)
				.reader(reader)
				.writer(writer)
				.processor(processor)
				.build();		
	}
	
	@Bean(name="factor")
	public Job createJob() {
		return jobFactory.get("factor")
				.incrementer(new RunIdIncrementer())
				.start(createStep())
				.build();
		
	}


}
