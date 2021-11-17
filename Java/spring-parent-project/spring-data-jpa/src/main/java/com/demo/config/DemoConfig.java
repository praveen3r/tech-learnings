package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan(basePackages={"com.demo.config","com.demo.entity","com.demo.repository","com.demo.service"})
@EnableJpaRepositories(basePackages = {"com.demo.repository","com.demo.repository.impl"})
//@EnableJpaRepositories(basePackages="com.demo.repository",excludeFilters=@Filter(type=FilterType.REGEX, pattern=".*SomeRepository" ),repositoryImplementationPostfix="Impl" )
@EnableAsync
public class DemoConfig {

	/*@Bean
	  public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
	      Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
	      factory.setResources(new Resource[] { new ClassPathResource("user.json")});
	      return factory;
	  }*/
	
	 @Bean("threadPoolTaskExecutor")
	    public TaskExecutor getAsyncExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(20);
	        executor.setMaxPoolSize(1000);
	        executor.setWaitForTasksToCompleteOnShutdown(true);
	        executor.setThreadNamePrefix("Async-");
	        return executor;
	    }

}
