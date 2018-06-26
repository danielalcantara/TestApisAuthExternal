package br.com.cea.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Component
@Configuration
@ComponentScan(basePackages = { "br.com.cea.*" })
@EnableTransactionManagement
@PropertySource({ "classpath:database.properties", "classpath:email_sry.properties", "classpath:queries.properties" })
public class BeanConfiguration implements TransactionManagementConfigurer {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("admry.data.base.class"));
		ds.setUrl(env.getProperty("admry.data.base.url"));
		ds.setUsername(env.getProperty("admry.data.base.user"));
		ds.setPassword(env.getProperty("admry.data.base.password"));
		ds.setDefaultAutoCommit(false);
		return ds;
	}

	@Bean
	public JdbcTemplate jdcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public NamedParameterJdbcTemplate namedJdcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager();
	}

}
