package com.demo.scheduler.annotation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.demo.scheduler.service.CronJobParam;
import com.demo.scheduler.service.CronSchedulerService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CronJobAnnotationProcessor implements ApplicationContextAware, EnvironmentAware{

	@Autowired
	private CronSchedulerService schedulerService;
	
	private Environment environment;
	
	public void processAnnotation(ApplicationContext applicationContext) throws BeansException{
		Map<String, Object> cronJobsBeans = applicationContext.getBeansWithAnnotation(CronJobs.class);
		Optional.ofNullable(cronJobsBeans).orElse(new HashMap()).values().stream().forEach(bean -> {
			CronJobs[] cronJobs = bean.getClass().getAnnotationsByType(CronJobs.class);
			for(CronJobs jobs: cronJobs) {
				createJob(jobs.value());
			}
		});
		Map<String, Object> cronJobBeans = applicationContext.getBeansWithAnnotation(CronJob.class);
		Optional.ofNullable(cronJobBeans).orElse(new HashMap()).values().stream().forEach(bean -> {
			CronJob[] cronJobs = bean.getClass().getAnnotationsByType(CronJob.class);
				createJob(cronJobs);
		});
	}
	
	private void createJob(CronJob[] cronJobs) {
		for(CronJob cronJob: cronJobs) {
			if(Boolean.parseBoolean(resolveProperty(cronJob.enabled()))) {
				CronJobParam jobParam = CronJobParam.builder().name(resolveProperty(cronJob.name()))
						.group(resolveProperty(cronJob.group()))
						.description(resolveProperty(cronJob.description()))
						.cronExpression(resolveProperty(cronJob.cronExpression()))
						.dataMap(Arrays.asList(cronJob.jobData()).stream()
								.collect(Collectors.toMap(data -> data.key(), data -> data.value())))
								.timeZoneId(resolveProperty(cronJob.timeZoneId())).build();
				schedulerService.createCronJob(cronJob.jobClass(), jobParam);
			}
		}
	}
	
	private String resolveProperty(String value) {
		return ObjectUtils.nullSafeToString(value).startsWith("$")?
				this.environment.resolvePlaceholders(value)
				: value;
	}
	
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
		processAnnotation(applicationContext);
	}
}
