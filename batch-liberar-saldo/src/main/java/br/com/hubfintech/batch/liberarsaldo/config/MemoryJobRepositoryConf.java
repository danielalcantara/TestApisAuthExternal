package br.com.hubfintech.batch.liberarsaldo.config;

/*@Configuration
@EnableTransactionManagement*/
public class MemoryJobRepositoryConf {
	
	/*@Bean
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
	}*/

}
