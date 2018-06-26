package br.com.cea.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cea.dao.logger.ReflectionLogger;

public class LancamentoPedidoModel implements Serializable, ReflectionLogger {

	private static final long serialVersionUID = -416906795713533227L;

	private Long id;
	private Long idContrato;
	private Date dataRecebementoDevolucaoItem;
	private Double valorLiquido;
	private Double valorBruto;
	private Long codigoDivisao;
	private Long codigoDepartamento;
	private Date dataGeracaoArquivo;
	private Date dataVencimentoArquivoSap;
	private Long numeroAtributoUsuario;
	private Long codigoValorAtbUsuario;
	private Timestamp dataInclusaoRegistro;
	private List<PedidoSkuModel> listaPedidoSku = new ArrayList<>();
	
	public void addPedidoSku(PedidoSkuModel pedidoSkuModel){
		listaPedidoSku.add(pedidoSkuModel);
	}
	
	public Date getDataRecebementoDevolucaoItem() {
		return dataRecebementoDevolucaoItem;
	}

	public void setDataRecebementoDevolucaoItem(Date dataRecebementoDevolucaoItem) {
		this.dataRecebementoDevolucaoItem = dataRecebementoDevolucaoItem;
	}

	public Long getCodigoDivisao() {
		return codigoDivisao;
	}

	public void setCodigoDivisao(Long codigoDivisao) {
		this.codigoDivisao = codigoDivisao;
	}

	public Long getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(Long codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public Date getDataGeracaoArquivo() {
		return dataGeracaoArquivo;
	}

	public void setDataGeracaoArquivo(Date dataGeracaoArquivo) {
		this.dataGeracaoArquivo = dataGeracaoArquivo;
	}

	public Date getDataVencimentoArquivoSap() {
		return dataVencimentoArquivoSap;
	}

	public void setDataVencimentoArquivoSap(Date dataVencimentoArquivoSap) {
		this.dataVencimentoArquivoSap = dataVencimentoArquivoSap;
	}

	public Long getNumeroAtributoUsuario() {
		return numeroAtributoUsuario;
	}

	public void setNumeroAtributoUsuario(Long numeroAtributoUsuario) {
		this.numeroAtributoUsuario = numeroAtributoUsuario;
	}

	public Long getCodigoValorAtbUsuario() {
		return codigoValorAtbUsuario;
	}

	public void setCodigoValorAtbUsuario(Long codigoValorAtbUsuario) {
		this.codigoValorAtbUsuario = codigoValorAtbUsuario;
	}

	public Timestamp getDataInclusaoRegistro() {
		return dataInclusaoRegistro;
	}

	public void setDataInclusaoRegistro(Timestamp dataInclusaoRegistro) {
		this.dataInclusaoRegistro = dataInclusaoRegistro;
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

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public List<PedidoSkuModel> getListaPedidoSku() {
		return listaPedidoSku;
	}

	public void setListaPedidoSku(List<PedidoSkuModel> pedidoSku) {
		this.listaPedidoSku = pedidoSku;
	}

	

}
