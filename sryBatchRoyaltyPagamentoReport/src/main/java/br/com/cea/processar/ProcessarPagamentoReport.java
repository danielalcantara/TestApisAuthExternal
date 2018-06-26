package br.com.cea.processar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cea.bo.IPagamentoReportBO;

@Component
public class ProcessarPagamentoReport {

	private static Logger logger = LogManager.getLogger();

	@Autowired
	private IPagamentoReportBO bo;

	public void processar() {

		boolean successProcess = true;

		logger.info("========= INICIANDO PROCESSAMENTO DO BATCH ===============");

		successProcess = bo.processarPedidos();

		successProcess = bo.fecharReportsVencidos();

		if (successProcess)
			logger.info("========== BATCH FINALIZADO COM SUCESSO! =================");
		else
			logger.info("========== BATCH FINALIZADO COM ERROS! =================");

	}
}
