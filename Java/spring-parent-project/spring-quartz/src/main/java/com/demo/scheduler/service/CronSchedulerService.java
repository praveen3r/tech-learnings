package com.demo.scheduler.service;

import java.text.ParseException;
import java.util.TimeZone;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CronSchedulerService extends SchedulerService{

	public void createCronJob(Class jobClass, CronJobParam jobParam) {
		Trigger trigger = createCronTrigger(jobParam);
		JobDetail jobDetail = createJobDetail(jobClass, jobParam);
		createScheduleJob(jobDetail, trigger);
	}
	
	private Trigger createCronTrigger(CronJobParam jobParam) {
		CronTriggerImpl factoryBean = new CronTriggerImpl();
		factoryBean.setName(jobParam.getName());
		factoryBean.setGroup(jobParam.getGroup());
		if(!ObjectUtils.isEmpty(jobParam.getTimeZoneId()))
			factoryBean.setTimeZone(TimeZone.getTimeZone(jobParam.getTimeZoneId()));
		else
			factoryBean.setTimeZone(TimeZone.getDefault());
		try {
			factoryBean.setCronExpression(jobParam.getCronExpression());
		}catch(ParseException parseException) {
			log.error("Exception parsing cron expression", parseException);
		}
		factoryBean.setDescription(jobParam.getDescription());
		factoryBean.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
		return factoryBean;
	}
	
}
