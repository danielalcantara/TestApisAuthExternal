package br.com.hubfintech.batch.liberarsaldo.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hubfintech.batch.liberarsaldo.model.Transaction;
import br.com.hubfintech.batch.liberarsaldo.model.TransactionProcess;

@Repository
public class TransactionRepository implements ITransactionRepository {

	@PersistenceContext(unitName = "processadora")
	private EntityManager em;

	private String codigosBandeira;

	@Autowired
	public TransactionRepository(Environment env) {
		this.codigosBandeira = env.getRequiredProperty("transacao.bandeira.codigos");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionFinalAuth() {
		Query query = em.createNativeQuery("SELECT t.CodigoTransacao, t.CodigoCartao, t.DataAutorizacao, t.Situacao, "
				+ "t.CodigoSituacao, t.CodigoTransacaoOrigem, t.AutorizadorDE48_61_5 FROM Processadora.dbo.Transacoes t "
				/*+ "INNER JOIN Cartoes c ON c.CodigoCartao = t.CodigoCartao "
				+ "INNER JOIN Modalidades m ON m.CodigoModalidade = c.CodigoModalidade "
				+ "INNER JOIN Produtos p ON p.CodigoProduto = m.CodigoProduto "
				+ "INNER JOIN Bandeiras b ON b.CodigoBandeira = p.CodigoBandeira "
				+ "WHERE t.CodigoSituacao = 1 AND t.AutorizadorDE48_61_5 = 1 AND dateadd(day, :days, DataAutorizacao) < GETDATE() "
				+ "AND b.CodigoBandeira IN (:codigosBandeira)"*/, Transaction.class);
		/*query.setParameter("days", EAuthType.FINAL_AUTH.getDays());
		query.setParameter("codigosBandeira", codigosBandeira);*/

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionUndefinedAuth() {
		Query query = em.createNativeQuery("SELECT t.CodigoTransacao, t.CodigoCartao, t.DataAutorizacao, t.Situacao, "
				+ "t.CodigoSituacao, t.CodigoTransacaoOrigem, t.AutorizadorDE48_61_5 FROM Processadora.dbo.Transacoes t "
				/*+ "INNER JOIN Cartoes c ON c.CodigoCartao = t.CodigoCartao "
				+ "INNER JOIN Modalidades m ON m.CodigoModalidade = c.CodigoModalidade "
				+ "INNER JOIN Produtos p ON p.CodigoProduto = m.CodigoProduto "
				+ "INNER JOIN Bandeiras b ON b.CodigoBandeira = p.CodigoBandeira "
				+ "WHERE t.CodigoSituacao = 1 AND t.AutorizadorDE48_61_5 = 0 AND dateadd(day, :days, DataAutorizacao) < GETDATE() "
				+ "AND b.CodigoBandeira IN (:codigosBandeira)"*/, Transaction.class);
		/*query.setParameter("days", EAuthType.UNDEFINED_AUTH.getDays());
		query.setParameter("codigosBandeira", codigosBandeira);*/

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionPreAuth() {
		Query query = em.createNativeQuery("SELECT t.CodigoTransacao, t.CodigoCartao, t.DataAutorizacao, t.Situacao, "
				+ "t.CodigoSituacao, t.CodigoTransacaoOrigem, t.AutorizadorDE48_61_5 FROM Processadora.dbo.Transacoes t "
				/*+ "INNER JOIN Cartoes c ON c.CodigoCartao = t.CodigoCartao "
				+ "INNER JOIN Modalidades m ON m.CodigoModalidade = c.CodigoModalidade "
				+ "INNER JOIN Produtos p ON p.CodigoProduto = m.CodigoProduto "
				+ "INNER JOIN Bandeiras b ON b.CodigoBandeira = p.CodigoBandeira "
				+ "WHERE t.CodigoSituacao = 1 AND t.AutorizadorDE48_61_5 = 4 AND dateadd(day, :days, DataAutorizacao) < GETDATE() "
				+ "AND t.CodigoTransacaoOrigem IS NULL AND (SELECT COUNT(ts.CodigoTransacao) FROM Processadora.dbo.Transacoes ts WHERE "
				+ "ts.CodigoTransacaoOrigem = t.CodigoTransacao) = 0 AND b.CodigoBandeira IN (:codigosBandeira)"*/,
				Transaction.class);
		/*query.setParameter("days", EAuthType.PRE_AUTH.getDays());
		query.setParameter("codigosBandeira", codigosBandeira);*/

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> getTransactionPreAuthWithIncremental() {
		Query query = em.createNativeQuery("SELECT t.CodigoTransacao, t.CodigoCartao, t.DataAutorizacao, t.Situacao, "
				+ "t.CodigoSituacao, t.CodigoTransacaoOrigem, t.AutorizadorDE48_61_5 FROM Processadora.dbo.Transacoes t "
				/*+ "INNER JOIN Cartoes c ON c.CodigoCartao = t.CodigoCartao "
				+ "INNER JOIN Modalidades m ON m.CodigoModalidade = c.CodigoModalidade "
				+ "INNER JOIN Produtos p ON p.CodigoProduto = m.CodigoProduto "
				+ "INNER JOIN Bandeiras b ON b.CodigoBandeira = p.CodigoBandeira "
				+ "WHERE t.CodigoSituacao = 1 AND t.AutorizadorDE48_61_5 = 4 AND dateadd(day, :days, DataAutorizacao) < GETDATE() "
				+ "AND t.CodigoTransacaoOrigem IS NOT NULL AND b.CodigoBandeira IN (:codigosBandeira) "*/
				+ "ORDER BY t.CodigoTransacaoOrigem, t.CodigoTransacao ", Transaction.class);
		/*query.setParameter("days", EAuthType.PRE_AUTH.getDays());
		query.setParameter("codigosBandeira", codigosBandeira);*/

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
		storedProcedure.setParameter("MotivoCancelamento", "Cancelada por decurso de prazo");
		storedProcedure.setParameter("UsuarioCancelamento", "Batch Liberar Saldo");

		storedProcedure.execute();

		codigoTransacaoRetorno = (Long) storedProcedure.getOutputParameterValue("CodigoTransacaoCancelamento");

		return codigoTransacaoRetorno;

	}

	@Override
	public Transaction finfByCodigoTransacao(Long codigoTransacao) {
		return em.find(Transaction.class, codigoTransacao);
	}

}
