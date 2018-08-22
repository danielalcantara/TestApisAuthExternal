package br.com.hubfintech.batch.liberarsaldo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MemoryJobRepositoryConf {
	
	@Autowired
	Environment env;

	/*@Bean(name = "emfSpringbatch")
	public EntityManagerFactory entityManager() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.valueOf("SQL_SERVER"));
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.SQLServer2008Dialect");

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setPersistenceUnitName("springbatchdb");
		emf.setPackagesToScan("");
		
		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", env.getRequiredProperty("springbatch.hibernate.dialect"));
		additionalProperties.put("hibernate.show_sql", env.getRequiredProperty("springbatch.hibernate.show_sql"));
		additionalProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("springbatch.hibernate.hbm2ddl.auto"));
		emf.setJpaProperties(additionalProperties);

		emf.afterPropertiesSet();

		return emf.getObject();
	}*/

	@Bean(name = "dsSpringbatch")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("springbatch.db.driver"));
		dataSource.setUrl(env.getRequiredProperty("springbatch.db.url"));
		dataSource.setUsername(env.getRequiredProperty("springbatch.db.username"));
		dataSource.setPassword(env.getRequiredProperty("springbatch.db.password"));
		return dataSource;
	}

	/*@Bean(name = "txSpringbatch")
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManager());
	}*/

	@Bean
	protected JobRepository jobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource());
		factory.setTransactionManager(transactionManager());
		factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
		factory.setTablePrefix("dbo.BATCH_");
		return factory.getObject();
	}

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

	/*@Bean
	public JobRepository jobRepository() throws Exception {
		return mapJobRepositoryFactory().getObject();
	}*/

	/*@Bean
	public JobExplorer jobExplorer() throws Exception {
		MapJobRepositoryFactoryBean factory = mapJobRepositoryFactory();
		return new SimpleJobExplorer(factory.getJobInstanceDao(), factory.getJobExecutionDao(),
				factory.getStepExecutionDao(), factory.getExecutionContextDao());
	}*/
	
	/*@Bean
	public MapJobRepositoryFactoryBean mapJobRepositoryFactory() throws Exception {
		MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean(transactionManager());
		factory.afterPropertiesSet();
		return factory;
	}*/

}
