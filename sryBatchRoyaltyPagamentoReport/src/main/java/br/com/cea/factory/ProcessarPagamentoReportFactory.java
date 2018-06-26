package br.com.cea.factory;

import br.com.cea.bo.IProcessarPagamentoReportBO;
import br.com.cea.dao.IPagamentoReportDAO;

public abstract class ProcessarPagamentoReportFactory {

	final static String PREFIX_NAME_CLASS = "br.com.cea.bo.impl.";

	public static IProcessarPagamentoReportBO getProcessarPagamentoReport(String className,
			IPagamentoReportDAO pagamentoReportDAO)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		IProcessarPagamentoReportBO processarPagamentoReportBO = null;

		if (className == null || className.trim().isEmpty())
			return null;

		processarPagamentoReportBO = (IProcessarPagamentoReportBO) Class.forName(PREFIX_NAME_CLASS + className.trim())
				.newInstance();
		processarPagamentoReportBO.setPagamentoReportDAO(pagamentoReportDAO);

		return processarPagamentoReportBO;
	}

}
