package com.demo.jpa.db.to.txt;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.demo.entity.EmployeeEntity;
import com.demo.listener.JobCompletionListener;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PlatformTransactionManager platformTransactionManager;
	
	
	  @Autowired LocalContainerEntityManagerFactoryBean entityManagerFactory;
	 
	
	/*
	 * @Autowired private EmployeeRepository repo;
	 */
	
	
	@Bean
	public ItemReader<EmployeeEntity> reader() throws Exception {
		JpaPagingItemReader<EmployeeEntity> reader = new JpaPagingItemReader<EmployeeEntity>();
		reader.setEntityManagerFactory(entityManagerFactory.getObject());
		reader.setQueryString("select e from EmployeeEntity e");
		reader.setPageSize(1);
		reader.afterPropertiesSet();

		return reader;
	}
	 
	
	/*
	 * @Bean public ItemReader<EmployeeEntity> reader() throws Exception {
	 * RepositoryItemReader<EmployeeEntity> reader = new
	 * RepositoryItemReader<EmployeeEntity>(); reader.setRepository(repo);
	 * reader.setMethodName("findAll");
	 * 
	 * HashMap sorts = new HashMap<>(); sorts.put("age", Direction.ASC);
	 * reader.setSort(sorts);
	 * 
	 * return reader; }
	 */

	
	@Bean
    ItemWriter<EmployeeEntity> writer() {
		FlatFileItemWriter<EmployeeEntity> writer = new FlatFileItemWriter<>();
		//writer.setResource(new ClassPathResource("employeeWrite.csv"));
		//writing in current directory
		writer.setResource(new FileSystemResource("/employeeWrite.txt"));
		
		DelimitedLineAggregator<EmployeeEntity> aggregator = new DelimitedLineAggregator<EmployeeEntity>();
		aggregator.setDelimiter(",");
		
		BeanWrapperFieldExtractor<EmployeeEntity> fieldExtractor = new BeanWrapperFieldExtractor<EmployeeEntity>();
		fieldExtractor.setNames(new String[] { "firstName", "lastName", "age" });
		aggregator.setFieldExtractor(fieldExtractor);
		
		writer.setLineAggregator(aggregator);
		
		return writer;
    }
	
	@Bean
	public JobRepository getJobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTransactionManager(platformTransactionManager);
        factory.afterPropertiesSet();
        return (JobRepository) factory.getObject();
    }
	
	@Bean
	public JobLauncher getJobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(getJobRepository());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

	//@JobScope
	@Bean
	public Job processJob() throws Exception{
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	//@JobScope
	@Bean
	public Step orderStep1() throws Exception{
		return stepBuilderFactory.get("orderStep1")
				.<EmployeeEntity, EmployeeEntity> chunk(1)
				.reader(reader())
				//.processor(new Processor())
				.writer(writer()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}
