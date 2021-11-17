package com.demo.tasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import com.demo.tasklet.TaskletStep;

import com.demo.entity.Employee;
import com.demo.listener.JobCompletionListener;

/*@Configuration
public class BatchConfig {

	@Autowired
	private TaskletStep taskletStep;
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.start(Step1()).next(Step2()).build();
	}

	@Bean
	public Step Step1() {
		return stepBuilderFactory.get("Step1")
				.<String, String> chunk(5)
				.reader(new Reader())
				.writer(new Writer()).build();
	}
	
	@Bean
	public Step Step2() {
		return stepBuilderFactory.get("Step2")
				.tasklet(taskletStep).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}*/
