package com.demo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = { "com.demo.repository" })
@EnableTransactionManagement
public class DatabaseConfig {
private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = { "com.demo.entity" };
	
	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.pwd}")
	private String pwd;	
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Value("${spring.datasource.testWhileIdle}")
	private boolean testWhileIdle;
	
	@Value("${spring.datasource.validationQuery}")
	private String validationQuery;
	
	@Value("${connection.pool.max_size}")
	private Integer connPoolMax;
	
	@Value("${connection.pool.timeout}")
	private Integer connPoolTimeout;
	
	@Primary
	@Bean(name = "dataSource",destroyMethod = "close")
	public DataSource dataSource() {
		
		var config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setUsername(username);
		config.setPassword(pwd);
		config.setJdbcUrl(dbUrl);
		config.setMaximumPoolSize(connPoolMax);
		config.setMinimumIdle(connPoolMax);

		config.setPoolName("DEMO-CONN-API-Pool");
		config.setIdleTimeout(connPoolTimeout * 1000);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
			
		 var datasource = new HikariDataSource(config);
	
		return  datasource;
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages(ENTITYMANAGER_PACKAGES_TO_SCAN).persistenceUnit("defaultUnit").build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
