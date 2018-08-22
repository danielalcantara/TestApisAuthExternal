package br.com.hubfintech.batch.liberarsaldo.itemreader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.hubfintech.batch.liberarsaldo.enums.EAuthType;
import br.com.hubfintech.batch.liberarsaldo.model.Transaction;

@Component
@Order(value = 4)
public class TransactionIdemReaderPreAuthInc extends TransactionItemReaderSimpleAbstract {

	private Long CODIGO_SITUACAO_CANCELADA = 2L;

	@Override
	protected void initialize() {
		transactionList = filterData(transactionRepo.getTransactionPreAuthWithIncremental());
	}

	private List<Transaction> filterData(List<Transaction> transactionList) {
		List<Transaction> transactionListCancel = new ArrayList<>();
		Long codigoOrigem = null;

		for (Transaction transaction : transactionList) {
			if (transaction.getCodigoTransacaoOrigem() == null)
				continue;

			if (!transaction.getCodigoTransacaoOrigem().equals(codigoOrigem)) {
				Calendar cal = Calendar.getInstance();
				Date currentDate = cal.getTime();
				cal.setTime(transaction.getDataAutorizacao());
				cal.add(Calendar.DATE, EAuthType.PRE_AUTH.getDays());
				Date expireDate = cal.getTime();
				codigoOrigem = transaction.getCodigoTransacaoOrigem();

				if (currentDate.after(expireDate)) {
					List<Transaction> transactionsCollect = transactionList.stream()
							.filter(t -> transaction.getCodigoTransacaoOrigem().equals(t.getCodigoTransacaoOrigem()))
							.collect(Collectors.toList());

					Transaction transactionOrigin = transactionRepo
							.finfByCodigoTransacao(transaction.getCodigoTransacaoOrigem());

					if (transactionOrigin != null
							&& !CODIGO_SITUACAO_CANCELADA.equals(transactionOrigin.getCodigoSituacao())) {
						transactionListCancel.add(transactionOrigin);
						transactionListCancel.addAll(transactionsCollect);
					}
				}
			}

		}

		return transactionListCancel;
	}

}
