package br.com.hubfintech.batch.liberarsaldo.processor;

import org.springframework.stereotype.Component;

import br.com.hubfintech.batch.liberarsaldo.enums.EAuthType;
import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;
import br.com.hubfintech.batch.liberarsaldo.util.RegisterCancellationsUtil;

@Component
public class TransactionItemProcessor implements ITransactionItemProcessor {

	@Override
	public TransactionProcess process(final Transaction transaction) throws Exception {
		RegisterCancellationsUtil.process++;
		TransactionProcess transactionProcess = new TransactionProcess(transaction.getCodigoTransacao(), "C", 2L,
				transaction.getDataAutorizacao());
		transactionProcess.setCodigoTeste(5);

		if (EAuthType.FINAL_AUTH.getTypeCode().equals(transaction.getCodeAuthType()))
			RegisterCancellationsUtil.qtdFinalAuth++;
		else if (EAuthType.PRE_AUTH.getTypeCode().equals(transaction.getCodeAuthType())) {
			transactionProcess.setCodigoTeste(null);
			RegisterCancellationsUtil.qtdPreAuth++;
		} else
			RegisterCancellationsUtil.qtdUndefinedAuth++;

		return transactionProcess;
	}

}
