package br.com.cea.bo;

import java.util.List;

import br.com.cea.dao.IPagamentoReportDAO;
import br.com.cea.model.ContratoModel;
import br.com.cea.model.LancamentoPeriodoModel;
import br.com.cea.model.ParcelaModel;
import br.com.cea.model.PeriodoModel;

public interface IProcessarPagamentoReportBO {

	public void processarPagamentoReport() throws Exception;

	public boolean fechamentoReport(LancamentoPeriodoModel lancamentoPeriodo, PeriodoModel periodoModel)
			throws Exception;

	public void processarPagamentoParcela(LancamentoPeriodoModel lancamentoPeriodoModel, List<ParcelaModel> parcelas)
			throws Exception;

	public void setContrato(ContratoModel contratoModel);

	public void setPagamentoReportDAO(IPagamentoReportDAO pagamentoReportDAO);

	public String getTipoGarantia();

	public void setTipoGarantia(String tipoGarantia);

}
