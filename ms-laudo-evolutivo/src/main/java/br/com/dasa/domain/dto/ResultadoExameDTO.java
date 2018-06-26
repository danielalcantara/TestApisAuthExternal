package br.com.dasa.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultadoExameDTO {

	private String codigo;
	private String descricao;
	private String valor;
	private List<ResultadoExameDTO> subResultadosExame;
	private String dataColeta;
	private String valorReferencia;
	private String statusResultado;

	public String getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(String dataColeta) {
		this.dataColeta = dataColeta;
	}

	public ResultadoExameDTO() {
		super();
		this.subResultadosExame = new ArrayList<>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public List<ResultadoExameDTO> getSubResultadosExame() {
		return subResultadosExame;
	}

	public void setSubResultadosExame(List<ResultadoExameDTO> subResultadosExame) {
		this.subResultadosExame = subResultadosExame;
	}

	public String getStatusResultado() {
		return statusResultado;
	}

	public String getValorReferencia() {
		return valorReferencia;
	}

	public void setValorReferencia(String valorReferencia) {
		this.valorReferencia = valorReferencia;
	}

	public void setStatusResultado(String statusResultado) {
		this.statusResultado = statusResultado;
	}

}
