package br.com.hubfintech.batch.liberarsaldo.model;

import java.util.Date;

public class TransactionProcess {

	private Long codigo;
	private Long cardId;
	private String situacao;
	private Long codigoSituacao;
	private Date dataAutorizacao;
	private boolean incremental = false;

	public TransactionProcess() {
		super();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Long getCodigoSituacao() {
		return codigoSituacao;
	}

	public void setCodigoSituacao(Long codigoSituacao) {
		this.codigoSituacao = codigoSituacao;
	}

	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}

	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public boolean isIncremental() {
		return incremental;
	}

	public void setIncremental(boolean incremental) {
		this.incremental = incremental;
	}

}
