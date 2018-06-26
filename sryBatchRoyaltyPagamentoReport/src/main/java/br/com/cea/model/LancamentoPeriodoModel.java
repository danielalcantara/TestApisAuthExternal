package br.com.cea.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.cea.dao.logger.ReflectionLogger;

public class LancamentoPeriodoModel implements Serializable, ReflectionLogger {

	private static final long serialVersionUID = 8410229190242940240L;

	private Long id;
	private Long idContrato;
	private Long idPeriodo;
	private Double valorBrutoConsolidado = 0D;
	private Double valorLiquidoConsolidado = 0D;
	private Double valorSaldoParcelaPendente = 0D;
	private Double valorSaldo = 0D;
	private Date dataAlteracaoRegistro;
	private Integer codigoPeriodicidade;
	private Date dataInicioReport;
	private Date dataFimReport;
	private Date dataInclusaoRegistro;
	private String statusReport;
	List<LancamentoPedidoModel> lancamentosPedido = new ArrayList<>();
	private Double valorConsumoDiario = 0D;
	private PagamentoModel pagamento;

	public Double getValorBrutoConsolidado() {
		return valorBrutoConsolidado;
	}

	public void setValorBrutoConsolidado(Double valorBrutoConsolidado) {
		this.valorBrutoConsolidado = valorBrutoConsolidado;
	}

	public Double getValorLiquidoConsolidado() {
		return valorLiquidoConsolidado;
	}

	public void setValorLiquidoConsolidado(Double valorLiquidoConsolidado) {
		this.valorLiquidoConsolidado = valorLiquidoConsolidado;
	}

	public Date getDataAlteracaoRegistro() {
		return dataAlteracaoRegistro;
	}

	public void setDataAlteracaoRegistro(Date dataAlteracaoRegistro) {
		this.dataAlteracaoRegistro = dataAlteracaoRegistro;
	}

	public Date getDataInicioReport() {
		return dataInicioReport;
	}

	public void setDataInicioReport(Date dataInicioReport) {
		this.dataInicioReport = dataInicioReport;
	}

	public Date getDataFimReport() {
		return dataFimReport;
	}

	public void setDataFimReport(Date dataFimReport) {
		this.dataFimReport = dataFimReport;
	}

	public Date getDataInclusaoRegistro() {
		return dataInclusaoRegistro;
	}

	public void setDataInclusaoRegistro(Date dataInclusaoRegistro) {
		this.dataInclusaoRegistro = dataInclusaoRegistro;
	}

	public String getStatusReport() {
		return statusReport;
	}

	public void setStatusReport(String statusReport) {
		this.statusReport = statusReport;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LancamentoPedidoModel> getLancamentosPedido() {
		return lancamentosPedido;
	}

	public void setLancamentosPedido(List<LancamentoPedidoModel> lancamentosPedido) {
		this.lancamentosPedido = lancamentosPedido;
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public Integer getCodigoPeriodicidade() {
		return codigoPeriodicidade;
	}

	public void setCodigoPeriodicidade(Integer codigoPeriodicidade) {
		this.codigoPeriodicidade = codigoPeriodicidade;
	}

	public Long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Double getValorSaldo() {
		return valorSaldo;
	}

	public void setValorSaldo(Double valorSaldo) {
		this.valorSaldo = valorSaldo;
	}

	public Double getValorSaldoParcelaPendente() {
		return valorSaldoParcelaPendente;
	}

	public void setValorSaldoParcelaPendente(Double valorSaldoParcelaPendente) {
		this.valorSaldoParcelaPendente = valorSaldoParcelaPendente;
	}

	public PagamentoModel getPagamento() {
		return pagamento;
	}

	public void setPagamento(PagamentoModel pagamento) {
		this.pagamento = pagamento;
	}

	public Double getValorConsumoDiario() {
		return valorConsumoDiario;
	}

	public void setValorConsumoDiario(Double valorConsumoDiario) {
		this.valorConsumoDiario = valorConsumoDiario;
	}

}
