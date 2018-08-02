package br.com.hubfintech.batch.liberarsaldo.repository;

import java.util.List;

import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;

public interface ITransactionRepository {

	List<Transaction> getTransactionFinalAuth();

	List<Transaction> getTransactionUndefinedAuth();

	List<Transaction> getTransactionPreAuth();

	List<Transaction> getTransactionPreAuthWithIncremental();

	Long cancelTransaction(TransactionProcess transactionProcess) throws Exception;

	public Transaction finfByCodigoTransacao(Long codigoTransacao);

}
