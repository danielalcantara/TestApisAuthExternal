package br.com.hubfintech.batch.liberarsaldo.itemreader;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.repository.ITransactionRepository;

public abstract class TransactionItemReaderSimpleAbstract implements ITransactionItemReader {

	protected List<Transaction> transactionList;

	private int nextTransactionIndex;

	@Autowired
	protected ITransactionRepository transactionRepo;

	@Autowired
	@PostConstruct
	public void postConstruct() {
		initialize();
	}

	@Override
	public Transaction read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		Transaction nextTransaction = null;

		if (nextTransactionIndex < transactionList.size())
			nextTransaction = transactionList.get(nextTransactionIndex++);

		return nextTransaction;
	}

	abstract protected void initialize();

}
