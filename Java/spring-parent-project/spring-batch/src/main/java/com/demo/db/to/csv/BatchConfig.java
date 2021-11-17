package com.demo.db.to.csv;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;

import com.demo.entity.Employee;
import com.demo.listener.JobCompletionListener;

/*@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	DataSource datasource;
	
	@Bean
	public JdbcCursorItemReader<Employee> reader() {
		JdbcCursorItemReader<Employee> reader = new JdbcCursorItemReader<Employee>();
		reader.setDataSource(datasource);
		reader.setSql("SELECT FIRST_NAME,LAST_NAME, AGE from EMPLOYEE");
		reader.setRowMapper(new EmployeeRowMapper());
		return reader;
	}
	
	public class EmployeeRowMapper implements RowMapper<Employee>{

		  @Override
		  public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			  Employee employee = new Employee();
			  employee.setFirstName(rs.getString("FIRST_NAME"));
			  employee.setLastName(rs.getString("LAST_NAME"));
			  employee.setAge(rs.getInt("AGE"));
		   
		   return employee;
		  }
		  
		 }

	
	@Bean
    ItemWriter<Employee> writer() {
		FlatFileItemWriter<Employee> writer = new FlatFileItemWriter<>();
		//writer.setResource(new ClassPathResource("employeeWrite.csv"));
		//writing in current directory
		writer.setResource(new FileSystemResource("/employeeWrite.csv"));
		
		DelimitedLineAggregator<Employee> aggregator = new DelimitedLineAggregator<Employee>();
		aggregator.setDelimiter(",");
		
		BeanWrapperFieldExtractor<Employee> fieldExtractor = new BeanWrapperFieldExtractor<Employee>();
		fieldExtractor.setNames(new String[] { "firstName", "lastName", "age" });
		aggregator.setFieldExtractor(fieldExtractor);
		
		writer.setLineAggregator(aggregator);
		
		return writer;
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
				.<Employee, Employee> chunk(1)
				.reader(reader())
				//.processor(new Processor())
				.writer(writer()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}*/
