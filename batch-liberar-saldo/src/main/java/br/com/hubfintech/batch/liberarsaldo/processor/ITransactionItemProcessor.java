package br.com.hubfintech.batch.liberarsaldo.processor;

import org.springframework.batch.item.ItemProcessor;

import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;

public interface ITransactionItemProcessor extends ItemProcessor<Transaction, TransactionProcess> {

}
