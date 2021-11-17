package com.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.demo.scheduler.annotation.CronJob;
import com.demo.scheduler.annotation.CronJobs;

@Component
@CronJobs({@CronJob(jobClass = DemoJob.class, name = "DemoScheduledJob",
		  group = "BATCH", description = "Demo Scheduled Job",
		   cronExpression = "${demo.scheduled.cron}")})
		  //timeZoneId = "Australia/Melbourne", cronExpression = "${demo.scheduled.cron}"))
public class DemoJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("coming here");
		
	}

}
