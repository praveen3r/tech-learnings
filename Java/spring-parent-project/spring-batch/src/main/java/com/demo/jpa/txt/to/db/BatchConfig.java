package com.demo.jpa.txt.to.db;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.demo.entity.Employee;
import com.demo.entity.EmployeeEntity;
import com.demo.listener.JobCompletionListener;

/*@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	 Writer writer;
	
	@Bean
	public FlatFileItemReader<EmployeeEntity> reader()
	{
	    //Create reader instance
	    FlatFileItemReader<EmployeeEntity> reader = new FlatFileItemReader<EmployeeEntity>();
	     
	    //Set input file location
	    reader.setResource(new ClassPathResource("employee.txt"));
	     
	    //Set number of lines to skips. Use it if file has header rows.
	    //reader.setLinesToSkip(1);  
	     
	    //Configure how each line will be parsed and mapped to different values
	    reader.setLineMapper(new DefaultLineMapper<EmployeeEntity>() {
	        {
	            //3 columns in each row
	            setLineTokenizer(new DelimitedLineTokenizer(",") {
	                {
	                    setNames(new String[] { "firstName", "lastName", "age" });
	                }
	            });
	            //Set values in Employee class
	            setFieldSetMapper(new BeanWrapperFieldSetMapper<EmployeeEntity>() {
	                {
	                    setTargetType(EmployeeEntity.class);
	                }
	            });
	        }
	    });
	    return reader;
	}
	
	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1")
				.<EmployeeEntity, EmployeeEntity> chunk(5)
				.reader(reader())
				//.processor(new Processor())
				.writer(writer).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}*/
