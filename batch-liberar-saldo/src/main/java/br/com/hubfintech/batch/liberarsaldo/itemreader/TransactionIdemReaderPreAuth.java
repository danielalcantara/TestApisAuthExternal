package br.com.hubfintech.batch.liberarsaldo.itemreader;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.hubfintech.batch.liberarsaldo.enums.EAuthType;

@Component
@Order(value = 3)
public class TransactionIdemReaderPreAuth extends TransactionItemReaderDefaultAbstract {

	@Override
	protected void initialize() {
		filterData(transactionRepo.getTransactionPreAuth(), EAuthType.PRE_AUTH);
	}

}
