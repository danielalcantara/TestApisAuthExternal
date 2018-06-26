package br.com.cea.model;

import java.util.Date;

import br.com.cea.dao.logger.ReflectionLogger;

public class ContratoModel implements ReflectionLogger {

	private Long id;
	private Date dataInicio;
	private Date dataFim;
	private Integer periodicidade;
	private GarantiaModel garantia;

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

	public Integer getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(Integer periodicidade) {
		this.periodicidade = periodicidade;
	}

	public GarantiaModel getGarantia() {
		return garantia;
	}

	public void setGarantia(GarantiaModel garantia) {
		this.garantia = garantia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}