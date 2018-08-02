package br.com.hubfintech.batch.liberarsaldo.itemwriter;

import org.springframework.batch.item.ItemWriter;

import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;

public interface ITransactionItemWriter extends ItemWriter<TransactionProcess> {

}
