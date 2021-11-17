package com.demo.multi.files;

import javax.sql.DataSource;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.demo.entity.Employee;
import com.demo.listener.JobCompletionListener;

/*@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Value("input/employee*.csv")
	private Resource[] resource;
	
	@Bean
	public MultiResourceItemReader<Employee> multiResourceItemReader(){
		MultiResourceItemReader<Employee> multiResourceItemReader = new MultiResourceItemReader<Employee>();
		multiResourceItemReader.setResources(resource);
		multiResourceItemReader.setDelegate(reader());
		return multiResourceItemReader;
	}
	
	@Bean
	public FlatFileItemReader<Employee> reader()
	{
	    //Create reader instance
	    FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
	     
	    //Set number of lines to skips. Use it if file has header rows.
	    //reader.setLinesToSkip(1);  
	     
	    //Configure how each line will be parsed and mapped to different values
	    reader.setLineMapper(new DefaultLineMapper<Employee>() {
	        {
	            //3 columns in each row
	            setLineTokenizer(new DelimitedLineTokenizer() {
	                {
	                    setNames(new String[] { "firstName", "lastName", "age" });
	                }
	            });
	            //Set values in Employee class
	            setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
	                {
	                    setTargetType(Employee.class);
	                }
	            });
	        }
	    });
	    return reader;
	}
	
	@Bean
    ItemWriter<Employee> writer() {
		FlatFileItemWriter<Employee> writer = new FlatFileItemWriter<>();
		writer.setResource(new FileSystemResource("/employeeWrite.csv"));

		writer.setAppendAllowed(true);
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
				.<Employee, Employee> chunk(5)
				.reader(multiResourceItemReader())
				//.processor(new Processor())
				.writer(writer()).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}*/
