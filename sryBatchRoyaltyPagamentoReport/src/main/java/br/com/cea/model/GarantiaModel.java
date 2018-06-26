package br.com.cea.model;

import java.util.List;

public class GarantiaModel {

	private Long id;
	private Long idContrato;
	private String tipo;
	private String descTipo;
	private String nomeClasseNegocio;
	private Double valor;
	List<PeriodoModel> periodos;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public List<PeriodoModel> getListPeriodos() {
		return periodos;
	}

	public void setListPeriodos(List<PeriodoModel> setPeriodos) {
		this.periodos = setPeriodos;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescTipo() {
		return descTipo;
	}

	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}

	public String getNomeClasseNegocio() {
		return nomeClasseNegocio;
	}

	public void setNomeClasseNegocio(String nomeClasseNegocio) {
		this.nomeClasseNegocio = nomeClasseNegocio;
	}

}
