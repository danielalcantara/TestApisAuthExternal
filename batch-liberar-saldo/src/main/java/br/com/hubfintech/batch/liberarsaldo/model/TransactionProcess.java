package br.com.hubfintech.batch.liberarsaldo.model;

import java.util.Date;

public class TransactionProcess {

	private Long codigo;
	private String situacao;
	private Long codigoSituacao;
	private Integer codigoTeste;
	private Date dataAutorizacao;
	
	public TransactionProcess() {
		super();
	}

	/**
	 * @param codigo
	 * @param situacao
	 * @param codigoSituacao
	 */
	public TransactionProcess(Long codigo, String situacao, Long codigoSituacao, Date dataAutorizacao) {
		super();
		this.codigo = codigo;
		this.situacao = situacao;
		this.codigoSituacao = codigoSituacao;
		this.dataAutorizacao = dataAutorizacao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Integer getCodigoTeste() {
		return codigoTeste;
	}

	public void setCodigoTeste(Integer codigoTeste) {
		this.codigoTeste = codigoTeste;
	}

	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}

	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

}
