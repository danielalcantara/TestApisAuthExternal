package br.com.hubfintech.batch.liberarsaldo.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(name = "persistence_config", value = "classpath:persistence_config.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.hubfintech.batch.liberarsaldo.repository", 
	entityManagerFactoryRef = "emfProcessadora", transactionManagerRef = "txProcessadora")
public class DataSourceConfiguration {

	@Autowired
	Environment env;

	@Bean(name = "emfProcessadora")
	public EntityManagerFactory entityManager() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.valueOf("SQL_SERVER"));
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.SQLServer2008Dialect");

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setPersistenceUnitName("processadora");
		
		// Classpath scanning of @Component, @Service, etc annotated class
		emf.setPackagesToScan(env.getProperty("entitymanager.packagesToScan"));

		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		additionalProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		additionalProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		emf.setJpaProperties(additionalProperties);

		emf.afterPropertiesSet();

		return emf.getObject();
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSource.setUrl(env.getRequiredProperty("db.url"));
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));
		return dataSource;
	}

	@Bean(name = "txProcessadora")
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManager());
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcePlaceholderResolver() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}