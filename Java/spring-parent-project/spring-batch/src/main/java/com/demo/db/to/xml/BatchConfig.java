package com.demo.db.to.xml;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.oxm.xstream.XStreamMarshaller;

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
		StaxEventItemWriter<Employee> writer = new StaxEventItemWriter<>();
		//writer.setResource(new ClassPathResource("employeeWrite.csv"));
		//writing in current directory
		writer.setResource(new FileSystemResource("/employeeWrite.xml"));
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("employee", "com.demo.entity.Employee");
		
		XStreamMarshaller marshaller = new XStreamMarshaller();
		marshaller.setAliases(map);
		
		writer.setMarshaller(marshaller);
		writer.setRootTagName("Employees");
		writer.setOverwriteOutput(true);
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
