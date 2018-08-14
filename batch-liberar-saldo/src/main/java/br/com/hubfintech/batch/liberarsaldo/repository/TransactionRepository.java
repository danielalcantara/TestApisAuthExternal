package br.com.hubfintech.batch.liberarsaldo.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.hubfintech.batch.liberarsaldo.enums.EAuthType;
import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;

@Component
public class TransactionRepository implements ITransactionRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionFinalAuth() {
		Query query = em.createNativeQuery("SELECT t.CodigoTransacao, t.CodigoCartao, t.DataAutorizacao, t.Situacao, "
				+ "t.CodigoSituacao, t.CodigoTransacaoOrigem, t.AutorizadorDE48_61_5 FROM Processadora.dbo.Transacoes t "
				+ "WHERE t.CodigoSituacao = 1 AND t.AutorizadorDE48_61_5 = 1 AND dateadd(day, :days, DataAutorizacao) < GETDATE()",
				Transaction.class);
		query.setParameter("days", EAuthType.FINAL_AUTH.getDays());

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionUndefinedAuth() {
		Query query = em.createNativeQuery("SELECT t.CodigoTransacao, t.CodigoCartao, t.DataAutorizacao, t.Situacao, "
				+ "t.CodigoSituacao, t.CodigoTransacaoOrigem, t.AutorizadorDE48_61_5 FROM Processadora.dbo.Transacoes t "
				+ "WHERE t.CodigoSituacao = 1 AND t.AutorizadorDE48_61_5 = 0 AND dateadd(day, :days, DataAutorizacao) < GETDATE()",
				Transaction.class);
		query.setParameter("days", EAuthType.UNDEFINED_AUTH.getDays());
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionPreAuth() {
		Query query = em.createNativeQuery("SELECT t.CodigoTransacao, t.CodigoCartao, t.DataAutorizacao, t.Situacao, "
				+ "t.CodigoSituacao, t.CodigoTransacaoOrigem, t.AutorizadorDE48_61_5 FROM Processadora.dbo.Transacoes t "
				+ "WHERE t.CodigoSituacao = 1 AND t.AutorizadorDE48_61_5 = 4 AND dateadd(day, :days, DataAutorizacao) < GETDATE() "
				+ "AND t.CodigoTransacaoOrigem IS NULL AND (SELECT COUNT(ts.CodigoTransacao) FROM Processadora.dbo.Transacoes ts WHERE "
				+ "ts.CodigoTransacaoOrigem = t.CodigoTransacao) = 0",
				Transaction.class);
		query.setParameter("days", EAuthType.PRE_AUTH.getDays());
		
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionPreAuthWithIncremental() {
		Query query = em.createNativeQuery("SELECT t.CodigoTransacao, t.CodigoCartao, t.DataAutorizacao, t.Situacao, "
				+ "t.CodigoSituacao, t.CodigoTransacaoOrigem, t.AutorizadorDE48_61_5 FROM Processadora.dbo.Transacoes t "
				+ "WHERE t.CodigoSituacao = 1 AND t.AutorizadorDE48_61_5 = 4 AND dateadd(day, :days, DataAutorizacao) < GETDATE() "
				+ "AND t.CodigoTransacaoOrigem IS NOT NULL ORDER BY t.CodigoTransacaoOrigem, t.CodigoTransacao",
				Transaction.class);
		query.setParameter("days", EAuthType.PRE_AUTH.getDays());
		
		return query.getResultList();
	}

	@Transactional(value = "txProcessadora")
	public Long cancelTransaction(TransactionProcess transactionProcess) throws Exception {

		Long codigoTransacaoRetorno = null;

		StoredProcedureQuery storedProcedure = null;

		storedProcedure = em.createStoredProcedureQuery("CancelaTransacao");

		storedProcedure.registerStoredProcedureParameter("CodigoTransacaoParaCancelamento", Long.class,
				ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("IdentificadorSituacaoTransacaoParaCancelamento", String.class,
				ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("DataAutorizacao", Date.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("CodigoTransacaoCancelamento", Long.class, ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("SituacaoTransacaoCancelamento", String.class,
				ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("IdentificadorSituacaoTransacaoCancelamento", String.class,
				ParameterMode.OUT);
		storedProcedure.registerStoredProcedureParameter("MotivoCancelamento", String.class, ParameterMode.IN);
		storedProcedure.registerStoredProcedureParameter("UsuarioCancelamento", String.class, ParameterMode.IN);

		storedProcedure.setParameter("CodigoTransacaoParaCancelamento", transactionProcess.getCodigo());
		storedProcedure.setParameter("IdentificadorSituacaoTransacaoParaCancelamento", "CANCELADA");
		storedProcedure.setParameter("DataAutorizacao", transactionProcess.getDataAutorizacao());
		storedProcedure.setParameter("MotivoCancelamento", "");
		storedProcedure.setParameter("UsuarioCancelamento", "");

		storedProcedure.execute();

		codigoTransacaoRetorno = (Long) storedProcedure.getOutputParameterValue("CodigoTransacaoCancelamento");

		if (codigoTransacaoRetorno != null) {
			Query query = em.createNativeQuery(
					"INSERT INTO clearing.dbo.Chargeback (creationDate, messageReasonCode, sendDate, status, "
							+ "idFirstPresentation, cardId, processorCode, ipmFileGenerated, ica) VALUES (GETDATE(), "
							+ "4808, null, null, null, :codigoCartao, :codigoTransacao ,null ,null)");

			query.setParameter("codigoCartao", transactionProcess.getCardId());
			query.setParameter("codigoTransacao", transactionProcess.getCodigo());

			if (query.executeUpdate() <= 0)
				throw new RuntimeException("Falha na inserção de registro de chargeback para a transação: "
						+ transactionProcess.getCodigo());
		}

		return codigoTransacaoRetorno;

	}

	@Override
	public Transaction finfByCodigoTransacao(Long codigoTransacao) {
		return em.find(Transaction.class, codigoTransacao);
	}

}
