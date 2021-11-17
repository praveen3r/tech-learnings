package com.demo.xml.to.db;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import com.demo.entity.Employee;
import com.demo.listener.JobCompletionListener;

/* @Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	DataSource datasource;
	
	@Bean
	public ItemReader<Employee> reader()
	{
	    //Create reader instance
		StaxEventItemReader<Employee> reader = new StaxEventItemReader<Employee>();
	     
	    //Set input file location
	    reader.setResource(new ClassPathResource("employee.xml"));
	    reader.setFragmentRootElementName("employee");
	    
	    Map<String,String> map = new HashMap<String,String>();
		map.put("employee", "com.demo.entity.Employee");
		
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAliases(map);
		
		reader.setUnmarshaller(marshaller);
		
	    return reader;
	}
	
	@Bean
    ItemWriter<Employee> writer() {
        JdbcBatchItemWriter<Employee> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(datasource);
        databaseItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
        databaseItemWriter.setSql("INSERT INTO EMPLOYEE(FIRST_NAME,LAST_NAME, AGE) VALUES(:firstName,:lastName,:age)");
        
        return databaseItemWriter;
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
				.<Employee, Employee> chunk(5)
				.reader(reader())
				//.processor(new Processor())
				.writer(writer()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}*/
