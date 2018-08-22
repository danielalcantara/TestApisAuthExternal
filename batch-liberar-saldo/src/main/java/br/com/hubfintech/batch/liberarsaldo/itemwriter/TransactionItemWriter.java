package br.com.hubfintech.batch.liberarsaldo.itemwriter;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;
import br.com.hubfintech.batch.liberarsaldo.repository.ITransactionRepository;
import br.com.hubfintech.batch.liberarsaldo.repository.TransactionRepository;
import br.com.hubfintech.batch.liberarsaldo.util.RegisterCancellationsUtil;

@Component
public class TransactionItemWriter implements ITransactionItemWriter {

	private static final Logger log = Logger.getLogger(TransactionRepository.class);

	private final String MSG_ERROR_PROCESS = "Falha no cancelamento da transação: ";

	@Autowired
	private ITransactionRepository transactionRepo;

	@Override
	public void write(List<? extends TransactionProcess> items) {

		for (TransactionProcess transactionProcess : items) {
			try {
				Long codigoTransacaoRetorno = transactionRepo.cancelTransaction(transactionProcess);

				if (codigoTransacaoRetorno == null && !transactionProcess.isIncremental()) {
					log.error(MSG_ERROR_PROCESS + transactionProcess.getCodigo());
					RegisterCancellationsUtil.qtdProcessErros++;
				}
			} catch (Exception ex) {
				log.error(MSG_ERROR_PROCESS + transactionProcess.getCodigo(), ex);
				RegisterCancellationsUtil.qtdProcessErros++;
			}
		}

	}

}
