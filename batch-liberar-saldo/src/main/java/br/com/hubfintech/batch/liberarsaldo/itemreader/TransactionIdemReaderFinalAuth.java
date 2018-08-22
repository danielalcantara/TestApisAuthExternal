package br.com.hubfintech.batch.liberarsaldo.itemreader;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.hubfintech.batch.liberarsaldo.enums.EAuthType;

@Component
@Order(value = 1)
public class TransactionIdemReaderFinalAuth extends TransactionItemReaderDefaultAbstract {

	@Override
	protected void initialize() {
		filterData(transactionRepo.getTransactionFinalAuth(), EAuthType.FINAL_AUTH);
	}

}
