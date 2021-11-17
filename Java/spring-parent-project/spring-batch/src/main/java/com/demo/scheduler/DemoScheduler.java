package com.demo.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/* @Component
@EnableScheduling
public class DemoScheduler {
	
	@Autowired
    JobLauncher jobLauncher;
 
    @Autowired
    Job processJob;*/
    
    //@Scheduled(cron = "*/10 * * * * *")
    /*public void execute() throws Exception{
    	JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
	            .toJobParameters();
	    jobLauncher.run(processJob, jobParameters);
	    System.out.println("Batch job has been invoked");
    }

}*/
