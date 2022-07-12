package com.example.config;





import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.entity.IExamResult;
import com.example.entity.OExamResult;
import com.example.listener.BatchListener;
import com.example.processor.Processor;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class Config {
	@Autowired
	public StepBuilderFactory stepFac;
	
	@Autowired
	public JobBuilderFactory jobFac;
	
	@Autowired
	public EntityManagerFactory entityMAnagerFactory;
	
	@Bean
	public ItemProcessor<IExamResult, OExamResult> createProcessor(){
		return new Processor();
	}
	
	@Bean
	public JobExecutionListener createListener() {
		return new BatchListener();
	}
	
	@Bean(name="read1")
	public FlatFileItemReader<IExamResult> createReader(){
		return new FlatFileItemReaderBuilder<IExamResult>()
				.name("read1")
				.resource(new FileSystemResource("E:\\ListOfStudentsWithPercentageBelow20.csv"))
				.delimited().delimiter(",")
				.names("id","dob","percentage","semester")
				.targetType(IExamResult.class)
				.build();		
	}
	@Bean(name="write1")
	public JpaItemWriter<OExamResult> createWriter() {
		return new JpaItemWriterBuilder<OExamResult>()
				.entityManagerFactory(entityMAnagerFactory)
				.build();
		
	}
	
	@Bean(name="step1")
	public Step createStep() {
		return stepFac.get("step1")
				.<IExamResult,OExamResult>chunk(10)
				.reader(createReader())
				.processor(createProcessor())
				.writer(createWriter())
				.build();		
	}
	
	@Bean(name="job")
	public Job CreateJob() {
		return jobFac.get("job")
				.listener(createListener())
				.incrementer(new RunIdIncrementer())
				.start(createStep())
				.build();
		
	}
	
}
