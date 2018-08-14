package br.com.hubfintech.batch.liberarsaldo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author Daniel Alcântara
 */
@Entity
@DynamicUpdate
@Table(name = "Transacoes")
public class Transaction {

	@Id
	@Column(name = "CodigoTransacao")
	private Long codigoTransacao;

	@Column(name = "CodigoCartao")
	private Long codigoCartao;

	@Column(name = "DataAutorizacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAutorizacao;

	@Column(name = "Situacao")
	private Character situacao;

	@Column(name = "CodigoSituacao")
	private Long codigoSituacao;

	@Column(name = "CodigoTransacaoOrigem")
	private Long codigoTransacaoOrigem;

	@Column(name = "AutorizadorDE48_61_5")
	private Integer codeAuthType;

	public Long getCodigoTransacao() {
		return codigoTransacao;
	}

	public void setCodigoTransacao(Long codigoTransacao) {
		this.codigoTransacao = codigoTransacao;
	}

	public Long getCodigoCartao() {
		return codigoCartao;
	}

	public void setCodigoCartao(Long codigoCartao) {
		this.codigoCartao = codigoCartao;
	}

	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}

	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public Character getSituacao() {
		return situacao;
	}

	public void setSituacao(Character situacao) {
		this.situacao = situacao;
	}

	public Long getCodigoSituacao() {
		return codigoSituacao;
	}

	public void setCodigoSituacao(Long codigoSituacao) {
		this.codigoSituacao = codigoSituacao;
	}

	public Long getCodigoTransacaoOrigem() {
		return codigoTransacaoOrigem;
	}

	public void setCodigoTransacaoOrigem(Long codigoTransacaoOrigem) {
		this.codigoTransacaoOrigem = codigoTransacaoOrigem;
	}

	public Integer getCodeAuthType() {
		return codeAuthType;
	}

	public void setCodeAuthType(Integer codeAuthType) {
		this.codeAuthType = codeAuthType;
	}

}
