package com.demo.scheduler.config;

import java.util.Optional;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@ConditionalOnProperty(name = "scheduler.enabled")
public class SchedulerConfig {

	@Autowired
	private SchedulerConfigProperties configProperties;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired(required=false)
	private DataSource dataSource;
	
	@Bean
	public SchedulerFactoryBean createSchedulerFactory() {
		SchedulerFactoryBean factory =new SchedulerFactoryBean();
		factory.setSchedulerName(configProperties.getInstanceName());
		factory.setOverwriteExistingJobs(true);
		factory.setStartupDelay(configProperties.getStartupDelay());
		factory.setDataSource(dataSource);
		factory.setQuartzProperties(loadQuartzProperties());
		SchedulerAutowiringJobFactory jobFactory = new SchedulerAutowiringJobFactory();
		jobFactory.setApplicationContext(applicationContext);
		factory.setJobFactory(jobFactory);
		return factory;
	}
	
	private Properties loadQuartzProperties() {
		Properties props = new Properties();
		props.put("org.quartz.scheduler.instanceName", configProperties.getInstanceName());
		props.put("org.quartz.scheduler.instanceId", "AUTO");
		props.put("org.quartz.scheduler.skipUpdateCheck", Boolean.TRUE.toString());
		props.put("org.quartz.scheduler.threadInheritContextClassLoaderOfInitializer", Boolean.TRUE.toString());
		props.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
		props.put("org.quartz.threadPool.threadCount", configProperties.getThreadPoolCount());
		props.put("org.quartz.threadPool.threadPriority", configProperties.getThreadPoolPriority());
		props.put("org.quartz.threadPool.threadInheritContextClassLoaderOfInitializingThread", Boolean.TRUE.toString());
		props.put("org.quartz.jobStore.class", "org.quartz.simpl.jdbcjobstore.JobStoreTX");
		props.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.simpl.jdbcjobstore.StdJDBCDelegate");
		props.put("org.quartz.jobStore.dataSource", "scheduledb");
		props.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
		props.put("org.quartz.jobStore.isClustered", Boolean.TRUE.toString());
		props.put("org.quartz.scheduler.jmx.export", Boolean.FALSE.toString());
		if(!Optional.ofNullable(dataSource).isPresent()) {
			props.put("org.quartz.dataSource.scheduledb.driver", configProperties.getDatasourceDriver());
			props.put("org.quartz.dataSource.scheduledb.URL", configProperties.getDatasourceUrl());
			props.put("org.quartz.dataSource.scheduledb.user", configProperties.getDatasourceUser());
			props.put("org.quartz.dataSource.scheduledb.password", configProperties.getDatasourcePassword());
		}
		return props;
	}
	
}
