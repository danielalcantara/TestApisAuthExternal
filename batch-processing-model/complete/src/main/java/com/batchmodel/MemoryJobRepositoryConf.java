package com.batchmodel;

import javax.sql.DataSource;

import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.SimpleJobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MemoryJobRepositoryConf {

	@Autowired
	private Environment env;

	@Bean
	public JobLauncher jobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository());
		return jobLauncher;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new ResourcelessTransactionManager();
	}

	@Bean
	public JobRepository jobRepository() throws Exception {
		return mapJobRepositoryFactory().getObject();
	}

	@Bean
	public JobExplorer jobExplorer() throws Exception {
		MapJobRepositoryFactoryBean factory = mapJobRepositoryFactory();
		return new SimpleJobExplorer(factory.getJobInstanceDao(), factory.getJobExecutionDao(),
				factory.getStepExecutionDao(), factory.getExecutionContextDao());
	}

	@Bean
	public MapJobRepositoryFactoryBean mapJobRepositoryFactory() throws Exception {
		MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean(transactionManager());
		factory.afterPropertiesSet();
		return factory;
	}

	@Bean
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getRequiredProperty("spring.h2.url"));
		dataSource.setDriverClassName(env.getRequiredProperty("spring.h2.driver-class-name"));
		dataSource.setUsername(env.getRequiredProperty("spring.h2.username"));
		dataSource.setPassword(env.getRequiredProperty("spring.h2.password"));
		return dataSource;
	}

}
