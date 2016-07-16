/*******************************************************************************
 * $Header$
 * $Revision$
 * $Date$
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2012 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年7月6日
 *******************************************************************************/

package com.showmecoo.web.management.test;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TODO 此处填写 class 信息
 *
 * @author yourname (mailto:yourname@primeton.com)
 */

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
	 /**
	   * DataSource definition for database connection. Settings are read from
	   * the application.properties file (using the env object).
	   */
	  @Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
	    dataSource.setUrl(env.getProperty("spring.datasource.url"));
	    dataSource.setUsername(env.getProperty("spring.datasource.username"));
	    dataSource.setPassword(env.getProperty("spring.datasource.password"));
	    return dataSource;
	  }

	  /**
	   * Declare the JPA entity manager factory.
	   */
	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean entityManagerFactory =
	        new LocalContainerEntityManagerFactoryBean();
	    
	    entityManagerFactory.setDataSource(dataSource);
	    
	    // Classpath scanning of @Component, @Service, etc annotated class
	    entityManagerFactory.setPackagesToScan(
	        env.getProperty("entitymanager.packagesToScan"));
	    
	    // Vendor adapter
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
	    
	    // Hibernate properties
	    Properties additionalProperties = new Properties();
	    additionalProperties.put(
	        "hibernate.dialect", 
	        env.getProperty("hibernate.dialect"));
	    additionalProperties.put(
	        "hibernate.show_sql", 
	        env.getProperty("hibernate.show_sql"));
	    additionalProperties.put(
	        "hibernate.hbm2ddl.auto", 
	        env.getProperty("hibernate.hbm2ddl.auto"));
	    entityManagerFactory.setJpaProperties(additionalProperties);
	    
	    return entityManagerFactory;
	  }

	  /**
	   * Declare the transaction manager.
	   */
	  @Bean
	  public JpaTransactionManager transactionManager() {
	    JpaTransactionManager transactionManager = 
	        new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(
	        entityManagerFactory.getObject());
	    return transactionManager;
	  }
	  
	  /**
	   * PersistenceExceptionTranslationPostProcessor is a bean post processor
	   * which adds an advisor to any bean annotated with Repository so that any
	   * platform-specific exceptions are caught and then rethrown as one
	   * Spring's unchecked data access exceptions (i.e. a subclass of 
	   * DataAccessException).
	   */
	  @Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	  }
	  
}

/*
 * 修改历史 $Log$
 */