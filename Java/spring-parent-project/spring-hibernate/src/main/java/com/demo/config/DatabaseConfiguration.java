package com.demo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
//import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.hibernate5.HibernateTransactionManager; 
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.orm.hibernate5
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@EnableTransactionManagement
public class DatabaseConfiguration {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String pwd;	
	
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String hibernateDialect;

	@Value("${spring.jpa.show-sql}")
	private String hibernateShowSql;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hibernateHbm2ddlAuto;
	
	@Value("${hibernate.connection.pool_size}")
	private String hibernateConnectionPoolSize;

	@Value("${hibernate.jdbc.batch_size}")
	private String hibernateJdbcBatchSize;

	@Value("${hibernate.c3p0.min_size}")
	private String hibernatePoolMin;
	@Value("${hibernate.c3p0.max_size}")
	private String hibernatePoolMax;
	@Value("${hibernate.c3p0.timeout}")
	private String hibernatePoolTimeout;
	@Value("${hibernate.c3p0.max_statements}")
	private String hibernateMaxStmnts;
	@Value("${hibernate.connection.autocommit}")
	private String hibernateAutoCommit;
	
	@Value("${spring.jpa.properties.hibernate.cache.use_second_level_cache}")
	private String isSecondLevelCache;
	
	@Value("${spring.jpa.properties.hibernate.cache.use_query_cache}")
	private String isQueryCache;
	
	@Value("${spring.jpa.properties.hibernate.cache.region.factory_class}")
	private String cacheRegionFactoryClass;
	
	@Value("${aeps.db.password.encrypted}")
	private String dbPasswordEncrypted;
	
	@Value("${spring.datasource.classname}")
	private String datasourceClassName;
	
	@Inject
	EntityManager entityManager;
	
	

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE = "hibernate.jdbc.batch_size";
	private static final String PROPERTY_NAME_HIBERNATE_C3P0_MAX_STMNT = "hibernate.c3p0.max_statements";
	private static final String PROPERTY_NAME_HIBERNATE_AUTOCOMMIT= "hibernate.connection.autocommit";
	
	private static final String PROPERTY_NAME_HIBERNATE_SECOND_LEVEL_CACHE= "hibernate.cache.use_second_level_cache";
	private static final String PROPERTY_NAME_HIBERNATE_QUERY_CACHE= "hibernate.cache.use_query_cache";
	private static final String PROPERTY_NAME_HIBERNATE_CACHE_FACTORY_CLASS= "hibernate.cache.region.factory_class";

	private static final String[] ENTITYMANAGER_PACKAGES_TO_SCAN = { "com.demo.entity"};				

	 @PostConstruct
	    private void init() {
		// TxnInfoRepositoryImpl.setEntityManager(entityManager);
	    }
	 
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
	    jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect); //spring.jpa.properties.hibernate.dialect
	    jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);//spring.jpa.show-sql
	    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	    localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	    localContainerEntityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
	    localContainerEntityManagerFactoryBean.setDataSource(dataSource);
	    localContainerEntityManagerFactoryBean.setJpaPropertyMap(createJpaProperties());
	    
	    localContainerEntityManagerFactoryBean.afterPropertiesSet();

	    return localContainerEntityManagerFactoryBean.getObject();
	}
	
	 private Map<String, ?> createJpaProperties () {
	        Map<String, Object> propertyMap = new HashMap();
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect); //spring.jpa.properties.hibernate.dialect
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);//spring.jpa.show-sql
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hibernateHbm2ddlAuto); //spring.jpa.hibernate.ddl-auto
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_AUTOCOMMIT, hibernateAutoCommit);

	        propertyMap.put(PROPERTY_NAME_HIBERNATE_SECOND_LEVEL_CACHE, isSecondLevelCache);
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_QUERY_CACHE, isQueryCache);
	        propertyMap.put(PROPERTY_NAME_HIBERNATE_CACHE_FACTORY_CLASS, cacheRegionFactoryClass);
			
	        return propertyMap;
	    }
	

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateDialect); //spring.jpa.properties.hibernate.dialect
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateShowSql);//spring.jpa.show-sql
		properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, hibernateHbm2ddlAuto); //spring.jpa.hibernate.ddl-auto
		properties.put(PROPERTY_NAME_HIBERNATE_JDBC_BATCH_SIZE, hibernateJdbcBatchSize); //hibernate.jdbc.batch_size
		properties.put(PROPERTY_NAME_HIBERNATE_AUTOCOMMIT, hibernateAutoCommit);
		
		properties.put(PROPERTY_NAME_HIBERNATE_C3P0_MAX_STMNT, hibernateMaxStmnts);
		
		properties.put(PROPERTY_NAME_HIBERNATE_SECOND_LEVEL_CACHE, isSecondLevelCache);
		properties.put(PROPERTY_NAME_HIBERNATE_QUERY_CACHE, isQueryCache);
		properties.put(PROPERTY_NAME_HIBERNATE_CACHE_FACTORY_CLASS, cacheRegionFactoryClass);
		
		return properties;
	}

	@Bean(name = "transactionManager")
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}	
	
	@Bean(name = "exceptionTranslation")
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	
	

}