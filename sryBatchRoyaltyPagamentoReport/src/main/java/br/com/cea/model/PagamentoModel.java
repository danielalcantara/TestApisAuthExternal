package br.com.cea.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import br.com.cea.dao.logger.ReflectionLogger;

public class PagamentoModel implements Serializable, ReflectionLogger {

	private static final long serialVersionUID = 4350832736258180961L;

	private Long id;
	private Long numeroContrato;
	private Date dataPagamento;
	private Double valorConsumo;
	private Double valorParcela;
	private Double valorPagamento;
	private Double valorSaldoParcelaPendente;
	private Double valorSaldo;
	private Timestamp dataInclusaoRegistro;
	private Long idReport;
	private Long numeroSequencialParcela;
	private Long numeroSequencialGarantia;
	private Long numeroContratoParcela;
	private Long idStatus;
	private String descStatus;
	private Date dataAprGes;
	private Date dataEtmPgt;
	private Date dataAltStatus;
	private Boolean stProcesso = false;
	private Boolean stProcessoStatus = false;

	public Long getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public Timestamp getDataInclusaoRegistro() {
		return dataInclusaoRegistro;
	}

	public void setDataInclusaoRegistro(Timestamp dataInclusaoRegistro) {
		this.dataInclusaoRegistro = dataInclusaoRegistro;
	}

	public Long getIdReport() {
		return idReport;
	}

	public void setIdReport(Long idReport) {
		this.idReport = idReport;
	}

	public Long getNumeroSequencialParcela() {
		return numeroSequencialParcela;
	}

	public void setNumeroSequencialParcela(Long numeroSequencialParcela) {
		this.numeroSequencialParcela = numeroSequencialParcela;
	}

	public Long getNumeroSequencialGarantia() {
		return numeroSequencialGarantia;
	}

	public void setNumeroSequencialGarantia(Long numeroSequencialGarantia) {
		this.numeroSequencialGarantia = numeroSequencialGarantia;
	}

	public Long getNumeroContratoParcela() {
		return numeroContratoParcela;
	}

	public void setNumeroContratoParcela(Long numeroContratoParcela) {
		this.numeroContratoParcela = numeroContratoParcela;
	}

	public Double getValorConsumo() {
		return valorConsumo;
	}

	public void setValorConsumo(Double valorConsumo) {
		this.valorConsumo = valorConsumo;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getDescStatus() {
		return descStatus;
	}

	public void setDescStatus(String descStatus) {
		this.descStatus = descStatus;
	}

	public Double getValorSaldoParcelaPendente() {
		return valorSaldoParcelaPendente;
	}

	public void setValorSaldoParcelaPendente(Double valorSaldoParcelaPendente) {
		this.valorSaldoParcelaPendente = valorSaldoParcelaPendente;
	}

	public Double getValorSaldo() {
		return valorSaldo;
	}

	public void setValorSaldo(Double valorSaldo) {
		this.valorSaldo = valorSaldo;
	}

	public Date getDataAprGes() {
		return dataAprGes;
	}

	public void setDataAprGes(Date dataAprGes) {
		this.dataAprGes = dataAprGes;
	}

	public Date getDataEtmPgt() {
		return dataEtmPgt;
	}

	public void setDataEtmPgt(Date dataEtmPgt) {
		this.dataEtmPgt = dataEtmPgt;
	}

	public Date getDataAltStatus() {
		return dataAltStatus;
	}

	public void setDataAltStatus(Date dataAltStatus) {
		this.dataAltStatus = dataAltStatus;
	}

	public Boolean getStProcesso() {
		return stProcesso;
	}

	public void setStProcesso(Boolean stProcesso) {
		this.stProcesso = stProcesso;
	}

	public Boolean getStProcessoStatus() {
		return stProcessoStatus;
	}

	public void setStProcessoStatus(Boolean stProcessoStatus) {
		this.stProcessoStatus = stProcessoStatus;
	}

}
