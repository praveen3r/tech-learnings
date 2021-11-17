package com.demo.db.to.xls;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	
	private static Integer CHUNK = 5;
	
	@Bean
	public ItemReader<Employee> reader() {
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
	public ItemStreamWriter<Employee> writer() {
	    return new EmployeeExcelWriter();
	}

	@Bean
    public Job job(Step step, JobExecutionListener listener) {
        return jobBuilderFactory.get("exportToXlsx")
                .start(step)
                .listener(listener)
                .build();
    }

	@Bean
    public Step step(ItemReader<Employee> reader, ItemWriter<Employee> writer) {
        return stepBuilderFactory.get("export")
                .<Employee, Employee>chunk(CHUNK)
                .reader(reader)
                .writer(writer)
                .build();
    }

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}*/
