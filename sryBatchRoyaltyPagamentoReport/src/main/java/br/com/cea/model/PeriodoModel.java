package br.com.cea.model;

import java.util.Date;
import java.util.List;

public class PeriodoModel {

	private Long id;
	private Long idContrato;
	private Date dataInicio;
	private Date dataFim;
	private Double valor;
	private List<ParcelaModel> parcelas;
	private List<LancamentoPeriodoModel> lancamentosPeriodo;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<ParcelaModel> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaModel> parcelas) {
		this.parcelas = parcelas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public List<LancamentoPeriodoModel> getLancamentosPeriodo() {
		return lancamentosPeriodo;
	}

	public void setLancamentosPeriodo(List<LancamentoPeriodoModel> lancamentosPeriodo) {
		this.lancamentosPeriodo = lancamentosPeriodo;
	}

}
