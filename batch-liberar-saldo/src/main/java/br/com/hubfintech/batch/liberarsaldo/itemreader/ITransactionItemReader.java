package br.com.hubfintech.batch.liberarsaldo.itemreader;

import org.springframework.batch.item.ItemReader;

import br.com.hubfintech.batch.liberarsaldo.model.Transaction;

public interface ITransactionItemReader extends ItemReader<Transaction> {

}
