package com.demo.scheduler.service;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchedulerService {
	
	@Autowired(required=false)
	private Scheduler scheduler;
	
	public void createScheduleJob(JobDetail jobDetail, Trigger trigger) {
		try {
			if(this.scheduler.checkExists(trigger.getKey())) {
				this.scheduler.pauseTrigger(trigger.getKey());
				this.scheduler.addJob(jobDetail, true);
				this.scheduler.rescheduleJob(trigger.getKey(), trigger);
			}else {
				this.scheduler.scheduleJob(jobDetail, trigger);
			}
		}catch(SchedulerException exp) {
			log.error("Exception while creating schedule job, job key : " + trigger.getKey(), exp);
			throw new RuntimeException("Exception while creating schedule job, job key : " + trigger.getKey(), exp);
		}
	}
	
	public JobDetail createJobDetail(Class jobClass, CronJobParam jobParam) {
		JobDetailImpl factoryBean = new JobDetailImpl();
		factoryBean.setJobClass(jobClass);
		factoryBean.setName(jobParam.getName());
		factoryBean.setGroup(jobParam.getGroup());
		factoryBean.setDurability(true);
		factoryBean.setDescription(jobParam.getDescription());
		factoryBean.setJobDataMap(new JobDataMap(jobParam.getDataMap()));
		return factoryBean;
	}

}
