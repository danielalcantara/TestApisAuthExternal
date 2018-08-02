package br.com.hubfintech.batch.liberarsaldo.config;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hubfintech.batch.liberarsaldo.enums.EAuthType;
import br.com.hubfintech.batch.liberarsaldo.itemwriter.ITransactionItemWriter;
import br.com.hubfintech.batch.liberarsaldo.listener.JobCompletionNotificationListener;
import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;
import br.com.hubfintech.batch.liberarsaldo.processor.ITransactionItemProcessor;
import br.com.hubfintech.batch.liberarsaldo.repository.ITransactionRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private ITransactionItemProcessor processor;

	@Autowired
	private ITransactionRepository transactionRepo;

	// tag::readers[]
	@Bean
	public ListItemReader<Transaction> readerFinalAuth() {
		return generateReaderFinalAuth();
	}

	@Bean
	public ListItemReader<Transaction> readerUndefinedAuth() {
		return generateReaderUndefinedAuth();
	}

	@Bean
	public ListItemReader<Transaction> readerPreAuth() {
		return generateReaderPreAuth();
	}

	@Bean
	public ListItemReader<Transaction> readerPreAuthInc() {
		return generateReaderPreAuthIncremental();
	}
	// end::readers[]

	// tag::jobstep[]
	@Bean
	public Job transactionCancellationJob(JobCompletionNotificationListener listener, Step... steps) {
		return jobBuilderFactory.get("transactionCancellationJob").incrementer(new RunIdIncrementer())
				.listener(listener).flow(steps[0]).next(steps[1]).next(steps[2]).next(steps[3]).end().build();
	}

	@Bean
	public Step step1(ITransactionItemWriter writer) {
		return stepBuilderFactory.get("step1").<Transaction, TransactionProcess>chunk(10).reader(readerFinalAuth())
				.processor(processor).writer(writer).build();
	}

	@Bean
	public Step step2(ITransactionItemWriter writer) {
		return stepBuilderFactory.get("step2").<Transaction, TransactionProcess>chunk(10).reader(readerUndefinedAuth())
				.processor(processor).writer(writer).build();
	}

	@Bean
	public Step step3(ITransactionItemWriter writer) {
		return stepBuilderFactory.get("step3").<Transaction, TransactionProcess>chunk(10).reader(readerPreAuth())
				.processor(processor).writer(writer).build();
	}

	@Bean
	public Step step4(ITransactionItemWriter writer) {
		return stepBuilderFactory.get("step4").<Transaction, TransactionProcess>chunk(10).reader(readerPreAuthInc())
				.processor(processor).writer(writer).build();
	}

	// end::jobstep[]

	private ListItemReader<Transaction> generateReaderFinalAuth() {
		return new ListItemReader<Transaction>(
				filterTransactionsCancel(transactionRepo.getTransactionFinalAuth(), EAuthType.FINAL_AUTH));
	}

	private ListItemReader<Transaction> generateReaderUndefinedAuth() {
		return new ListItemReader<Transaction>(
				filterTransactionsCancel(transactionRepo.getTransactionUndefinedAuth(), EAuthType.UNDEFINED_AUTH));
	}

	private ListItemReader<Transaction> generateReaderPreAuth() {
		return new ListItemReader<Transaction>(
				filterTransactionsCancel(transactionRepo.getTransactionPreAuth(), EAuthType.PRE_AUTH));
	}

	private ListItemReader<Transaction> generateReaderPreAuthIncremental() {
		return new ListItemReader<Transaction>(
				filterTransactionsPreIncCancel(transactionRepo.getTransactionPreAuthWithIncremental()));
	}

	private List<Transaction> filterTransactionsCancel(List<Transaction> transactionList, EAuthType authType) {
		List<Transaction> transactionListCancel = new ArrayList<>();

		for (Transaction transaction : transactionList) {
			Calendar cal = Calendar.getInstance();
			Date currentDate = cal.getTime();
			cal.setTime(transaction.getDataAutorizacao());
			cal.add(Calendar.DATE, authType.getDays());
			Date expireDate = cal.getTime();

			if (currentDate.after(expireDate))
				transactionListCancel.add(transaction);
		}

		return transactionListCancel;
	}

	private List<Transaction> filterTransactionsPreIncCancel(List<Transaction> transactionList) {
		List<Transaction> transactionListCancel = new ArrayList<>();
		Long codigoOrigem = null;

		for (Transaction transaction : transactionList) {
			if (transaction.getCodigoTransacaoOrigem() == null)
				continue;

			if (!transaction.getCodigoTransacaoOrigem().equals(codigoOrigem)) {
				Calendar cal = Calendar.getInstance();
				Date currentDate = cal.getTime();
				cal.setTime(transaction.getDataAutorizacao());
				cal.add(Calendar.DATE, EAuthType.PRE_AUTH.getDays());
				Date expireDate = cal.getTime();
				codigoOrigem = transaction.getCodigoTransacaoOrigem();

				if (currentDate.after(expireDate)) {
					List<Transaction> transactionsCollect = transactionList.stream()
							.filter(t -> transaction.getCodigoTransacaoOrigem().equals(t.getCodigoTransacaoOrigem()))
							.collect(Collectors.toList());

					Transaction transactionOrigin = transactionRepo
							.finfByCodigoTransacao(transaction.getCodigoTransacaoOrigem());

					if (transactionOrigin != null) {
						transactionListCancel.add(transactionOrigin);
						transactionListCancel.addAll(transactionsCollect);
					}
				}
			}

		}

		return transactionListCancel;
	}

}
