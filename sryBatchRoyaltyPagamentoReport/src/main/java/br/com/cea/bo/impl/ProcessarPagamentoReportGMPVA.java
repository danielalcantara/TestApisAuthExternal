package br.com.cea.bo.impl;

import java.util.List;

import br.com.cea.bo.IProcessarPagamentoReportBO;
import br.com.cea.model.LancamentoPeriodoModel;
import br.com.cea.model.PagamentoModel;
import br.com.cea.model.ParcelaModel;
import br.com.cea.model.PeriodoModel;
import br.com.cea.util.DateUtil;

public class ProcessarPagamentoReportGMPVA extends ProcessarPagamentoReportTemplate
		implements IProcessarPagamentoReportBO {

	@Override
	public void processarPagamentoReport() throws Exception {
		super.processarPagamentoReport();
	}

	@Override
	public void processarPagamentoParcela(LancamentoPeriodoModel lancamentoPeriodoModel, List<ParcelaModel> parcelas)
			throws Exception {
		super.processarPagamentoParcela(lancamentoPeriodoModel, parcelas);
	}

	@Override
	public boolean fechamentoReport(LancamentoPeriodoModel lancamentoPeriodo, PeriodoModel periodoModel)
			throws Exception {

		boolean successProcess = super.fechamentoReport(lancamentoPeriodo, periodoModel);

		if (successProcess) {
			if (DateUtil.compareDateWithoutTime(lancamentoPeriodo.getDataFimReport(), contrato.getDataFim()) >= 0) {
				Double valorTotalGarantia = contrato.getGarantia().getValor();
				Integer lastIndexPeriodo = contrato.getGarantia().getListPeriodos().size() - 1;
				Integer lastIndexParcela = contrato.getGarantia().getListPeriodos().get(lastIndexPeriodo).getParcelas()
						.size() - 1;

				valorTotalGarantia -= contrato.getGarantia().getListPeriodos().get(lastIndexPeriodo).getParcelas()
						.get(lastIndexParcela).getValor();

				Double valorSaldo = lancamentoPeriodo.getValorSaldo() * -1;

				if (valorSaldo > 0D && valorTotalGarantia > valorSaldo) {
					Double valorPagamento = valorTotalGarantia - valorSaldo;
					PagamentoModel pagamento = geraPagamentoComplementar(lancamentoPeriodo, valorPagamento);

					pagamentoReportDAO.savePagamento(pagamento);
				}
			}
		}

		return successProcess;

	}

	protected void acumularValores(LancamentoPeriodoModel lancamentoPeriodoModel) {
		super.acumularValores(lancamentoPeriodoModel);
	}

	protected void processarSaldo(LancamentoPeriodoModel lancamentoPeriodo, List<ParcelaModel> parcelas)
			throws Exception {
		super.processarSaldo(lancamentoPeriodo, parcelas);
	}

	protected boolean processarPagamentoConsumo(LancamentoPeriodoModel lancamentoPeriodoModel, boolean fechamento)
			throws Exception {
		return super.processarPagamentoConsumo(lancamentoPeriodoModel, fechamento);
	}

}
