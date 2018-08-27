package br.com.hubfintech.batch.liberarsaldo.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import br.com.hubfintech.batch.liberarsaldo.itemreader.ITransactionItemReader;
import br.com.hubfintech.batch.liberarsaldo.itemwriter.ITransactionItemWriter;
import br.com.hubfintech.batch.liberarsaldo.listener.JobCompletionNotificationListener;
import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;
import br.com.hubfintech.batch.liberarsaldo.processor.ITransactionItemProcessor;

@Configuration
@EnableBatchProcessing
@PropertySource(name = "app_config", value = "file:/opt/vp/app/batch-liberar-saldo/config/app_config.properties")
@EnableAutoConfiguration
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ITransactionItemProcessor processor;

	@Autowired
	private List<ITransactionItemReader> readers;

	// tag::jobstep[]
	@Bean
	public Job transactionCancellationJob(JobCompletionNotificationListener listener, Step... steps) {
		return jobBuilderFactory.get("transactionCancellationJob").incrementer(new RunIdIncrementer())
				.listener(listener).flow(steps[0]).next(steps[1]).next(steps[2]).next(steps[3]).end().build();
	}

	@Bean
	public Step stepFinalAuth(ITransactionItemWriter writer) {
		return stepBuilderFactory.get("step1").<Transaction, TransactionProcess>chunk(10).reader(readers.get(0))
				.processor(processor).writer(writer).build();
	}

	@Bean
	public Step stepUndefinedAuth(ITransactionItemWriter writer) {
		return stepBuilderFactory.get("step2").<Transaction, TransactionProcess>chunk(10).reader(readers.get(1))
				.processor(processor).writer(writer).build();
	}

	@Bean
	public Step stepPreAuth(ITransactionItemWriter writer) {
		return stepBuilderFactory.get("step3").<Transaction, TransactionProcess>chunk(10).reader(readers.get(2))
				.processor(processor).writer(writer).build();
	}

	@Bean
	public Step stepPreAuthIncremental(ITransactionItemWriter writer) {
		return stepBuilderFactory.get("step4").<Transaction, TransactionProcess>chunk(10).reader(readers.get(3))
				.processor(processor).writer(writer).build();
	}
	// end::jobstep[]

}
