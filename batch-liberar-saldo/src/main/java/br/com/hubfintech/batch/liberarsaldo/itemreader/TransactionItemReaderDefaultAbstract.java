package br.com.hubfintech.batch.liberarsaldo.itemreader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.hubfintech.batch.liberarsaldo.enums.EAuthType;
import br.com.hubfintech.batch.liberarsaldo.model.Transaction;

public abstract class TransactionItemReaderDefaultAbstract extends TransactionItemReaderSimpleAbstract {

	protected void filterData(List<Transaction> transactionList, EAuthType authType) {
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

		this.transactionList = transactionListCancel;
	}

}
