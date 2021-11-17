package com.demo.xls.to.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.batch.item.excel.support.rowset.RowSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

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
    ItemStreamReader<Employee> reader() {
        PoiItemReader<Employee> reader = new PoiItemReader<Employee>();
        reader.setResource(new ClassPathResource("employee.xlsx"));
        reader.setRowMapper(new EmployeeRowMapper());
        reader.setLinesToSkip(1);
 
        return reader;
    }
	
	public class EmployeeRowMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(RowSet rs) throws Exception {
			if (rs == null || rs.getCurrentRow() == null) {
	            return null;
	        }
			Employee bl = new Employee();
	        bl.setFirstName(rs.getColumnValue(0));
	        bl.setLastName(rs.getColumnValue(1));
	        bl.setAge((Double.valueOf(rs.getColumnValue(2))).intValue());
	        return bl;
			}
		  
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
