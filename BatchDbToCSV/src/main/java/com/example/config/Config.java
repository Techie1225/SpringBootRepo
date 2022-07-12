package com.example.config;





import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.entity.ExamResult;
import com.example.listener.BatchListener;
import com.example.processor.Processor;

@Configuration
@EnableBatchProcessing
public class Config {

	@Autowired
	public StepBuilderFactory stepFac;
	@Autowired
	public JobBuilderFactory jobFac;
	
	@Autowired
	public DataSource ds;
	
	@Bean
	public ItemProcessor<ExamResult, ExamResult> createProcessor(){
		return new Processor();
	}
	
	@Bean
	public JobExecutionListener createListener() {
		return new BatchListener();
	}
	
	@Bean(name="read1")
	public JdbcCursorItemReader<ExamResult> createReader(){
		return new JdbcCursorItemReaderBuilder<ExamResult>()
				.name("read1")
				.dataSource(ds)
				.sql("SELECT id,dob,percentage,semester FROM exam_result")
				.beanRowMapper(ExamResult.class)
				.build();
		
	}
	@Bean(name="write1")
	public FlatFileItemWriter<ExamResult> createWriter() {
		return new FlatFileItemWriterBuilder<ExamResult>()
				.name("write1")
				.resource(new FileSystemResource("E:\\ListOfStudentsWithPercentageBelow20.csv"))
				.lineSeparator("\r\n")
				.delimited().delimiter(",")
				.names("id","dob","percentage","semester")
				.build();
		
	}
	
	@Bean(name="step1")
	public Step createStep() {
		return stepFac.get("step1")
				.<ExamResult,ExamResult>chunk(10)
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
