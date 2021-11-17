package com.demo.scheduler.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(CronJobs.class)
@Documented
public @interface CronJob {

	Class jobClass();
	
	String name();
	
	String group();
	
	String description();
	
	String cronExpression();
	
	JobData[] jobData() default {};
	
	String timeZoneId() default "";
	
	String enabled() default "true";
}
