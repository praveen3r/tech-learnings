package com.demo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
//import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.hibernate5.HibernateTransactionManager; 
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.hibernate5
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
//import com.fisglobal.fsg.web.aeps.repositories.impl.TxnInfoRepositoryImpl;

/**
 * Database Configuration
 * 
 * @author e3026216
 *
 */
@Configuration
public class DatabaseConfiguration {

	private String dbUrl = "jdbc:h2:mem:credit-card";

	private String username = "postgres";

	private String pwd = "";	
	
	private String driverClassName = "org.h2.Driver";

	private String hibernateDialect = "org.hibernate.dialect.H2Dialect";

	private String hibernateShowSql = "true";

	private String hibernateHbm2ddlAuto = "update";
	
	private String hibernateJdbcBatchSize = "2";

	private String hibernatePoolMax= "2";
	
	private String hibernatePoolTimeout = "1800";
	
	private String hibernateMaxStmnts = "10";
	
	private String hibernateAutoCommit = "true";
	
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	private static final String PROPERTY_NAME_HIBERNATE_C3P0_MAX_STMNT = "hibernate.c3p0.max_statements";
	private static final String PROPERTY_NAME_HIBERNATE_AUTOCOMMIT= "hibernate.connection.autocommit";
	
	private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = { "com.demo.entity"};				

	 @Bean(name = "dataSource",destroyMethod = "shutdown")
	@Primary
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setUsername(username);
		String decryptedPasswd =pwd;
		String decryptedDbUrl =dbUrl;
		
		config.setPassword(decryptedPasswd);
		config.setJdbcUrl(decryptedDbUrl);
		config.setMaximumPoolSize(Integer.valueOf(hibernatePoolMax));
		config.setMinimumIdle(Integer.valueOf(hibernatePoolMax));

		config.setPoolName("AEPS-API-Pool");
		int idleTimeOutVal = Integer.valueOf(hibernatePoolTimeout);
		config.setIdleTimeout(idleTimeOutVal * 1000);
		config.setInitializationFailFast(true);
		config.addDataSourceProperty("cachePrepStmts", "true");
		 config.addDataSourceProperty("prepStmtCacheSize", "250");
			
		 HikariDataSource datasource = new HikariDataSource(config);
		 

		return  datasource;
	}
	
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	
	@Bean(name = "entityManagerFactory")
	@Primary
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    Properties jpaProperties = new Properties();
	    jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect); 
	    jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
	    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	    localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	    localContainerEntityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
	    localContainerEntityManagerFactoryBean.setDataSource(dataSource);
	    localContainerEntityManagerFactoryBean.setJpaPropertyMap(createJpaProperties());
	    
	    localContainerEntityManagerFactoryBean.afterPropertiesSet();

	    return localContainerEntityManagerFactoryBean.getObject();
	}
	
	 private Map<String, ?> createJpaProperties () {
	        Map<String, Object> propertyMap = new HashMap<>();
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect); 
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hibernateHbm2ddlAuto);
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_AUTOCOMMIT, hibernateAutoCommit);

	        return propertyMap;
	    }
	

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect); 
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);
		properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hibernateHbm2ddlAuto); 
		properties.put(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE, hibernateJdbcBatchSize); 
		properties.put(PROPERTY_NAME_HIBERNATE_AUTOCOMMIT, hibernateAutoCommit);
		properties.put(PROPERTY_NAME_HIBERNATE_C3P0_MAX_STMNT, hibernateMaxStmnts);
		
		return properties;
	}

}