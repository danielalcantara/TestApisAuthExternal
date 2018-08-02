package br.com.hubfintech.batch.liberarsaldo.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;

@Component
public class TransactionRepository implements ITransactionRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Transaction> getTransactionFinalAuth() {
		TypedQuery<Transaction> query = em.createQuery(
				"SELECT t FROM Transaction t WHERE t.codigoSituacao = 1 AND t.codeAuthType = 1", Transaction.class);
		return query.getResultList();
	}

	@Override
	public List<Transaction> getTransactionUndefinedAuth() {
		TypedQuery<Transaction> query = em.createQuery(
				"SELECT t FROM Transaction t WHERE t.codigoSituacao = 1 AND t.codeAuthType = 0", Transaction.class);
		return query.getResultList();
	}

	@Override
	public List<Transaction> getTransactionPreAuth() {
		TypedQuery<Transaction> query = em.createQuery(
				"SELECT t FROM Transaction t WHERE t.codigoSituacao = 1 AND t.codeAuthType = 4 AND t.codigoTransacaoOrigem IS NULL"
						+ " AND (SELECT COUNT(ts.codigoTransacao) FROM Transaction ts WHERE ts.codigoTransacaoOrigem = t.codigoTransacao) = 0",
				Transaction.class);
		return query.getResultList();
	}

	@Override
	public List<Transaction> getTransactionPreAuthWithIncremental() {
		TypedQuery<Transaction> query = em.createQuery(
				"SELECT t FROM Transaction t WHERE t.codigoSituacao = 1 AND t.codeAuthType = 4 "
						+ " AND t.codigoTransacaoOrigem IS NOT NULL ORDER BY t.codigoTransacaoOrigem, t.codigoTransacao",
				Transaction.class);
		return query.getResultList();
	}

	@Transactional(value = "txProcessadora")
	public Long cancelTransaction(TransactionProcess transactionProcess) throws Exception {

		Long codigoTransacaoRetorno = null;

		StoredProcedureQuery storedProcedure = null;

		storedProcedure = em.createStoredProcedureQuery("CancelaTransacao_preauth");

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
			Query query = em.createQuery(
					"INSERT INTO clearing..Chargeback VALUES (GETDATE(), 4808, null, null, :idFirstPresentation, :codigoCartao, :codigoTransacao ,null ,null)");
			query.setParameter("idFirstPresentation", "");
			query.setParameter("codigoCartao", "");
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
