package br.com.dasa.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class ExameDTO {

	private String codigoOrigem;
	private String nome;
	private String dataRequisicao;
	private List<ResultadoExameDTO> resultadosExame;
	private String status;

	public ExameDTO() {
		super();
		resultadosExame = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(String dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public List<ResultadoExameDTO> getResultadosExame() {
		return resultadosExame;
	}

	public void setResultadosExame(List<ResultadoExameDTO> resultadosExame) {
		this.resultadosExame = resultadosExame;
	}

	public String getCodigoOrigem() {
		return codigoOrigem;
	}

	public void setCodigoOrigem(String codigoOrigem) {
		this.codigoOrigem = codigoOrigem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
