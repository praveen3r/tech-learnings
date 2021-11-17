package com.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, BatchAutoConfiguration.class})
@SpringBootApplication
@EnableBatchProcessing
public class DemoApplication2 implements CommandLineRunner{

	@Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job processJob;
 
	public static void main(String[] args) {
		SpringApplication sp = new SpringApplication(DemoApplication2.class);
		sp.run(args);
	}

	@Override
    public void run(String... args) throws Exception {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
	            .toJobParameters();
	    jobLauncher.run(processJob, jobParameters);
	    System.out.println("Batch job has been invoked");
	}
}
