package com.demo.scheduler.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public final class SchedulerAutowiringJobFactory extends SpringBeanJobFactory 
	implements ApplicationContextAware{
	
	private transient AutowireCapableBeanFactory beanFactory;
	
	@Override
	public void setApplicationContext(final ApplicationContext context) {
		beanFactory = context.getAutowireCapableBeanFactory();
	}

	
	protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception{
		final Object job = super.createJobInstance(bundle);
		beanFactory.autowireBean(job);
		return job;
	}
}
