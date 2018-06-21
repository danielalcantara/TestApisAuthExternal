package br.com.hubfintech.extauthtests.report;

import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class GeradorRelatorio {

	private String nomeArquivo;
	private Map<String, Object> parametros;
	private Connection connection;
	private JRDataSource dataSource;

	public GeradorRelatorio(String nomeArquivo, Map<String, Object> parametros, Connection connection) {
		this.nomeArquivo = nomeArquivo;
		this.parametros = parametros;
		this.connection = connection;
	}
	
	public GeradorRelatorio(String nomeArquivo, Map<String, Object> parametros, JRDataSource dataSource) {
		this.nomeArquivo = nomeArquivo;
		this.parametros = parametros;
		this.dataSource = dataSource;
	}

	public void geraPDFParaOutputStream(OutputStream outputStream) throws JRException {

		try {
			JasperPrint jasperPrint = null;
			
			if (connection != null)
				jasperPrint = JasperFillManager.fillReport (this.nomeArquivo, this.parametros, this.connection);
			else if (dataSource != null)
				jasperPrint = JasperFillManager.fillReport(this.nomeArquivo, this.parametros, this.dataSource);
			else
				throw new JRException("Connection or datasouce is null.");
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

		} catch (JRException e) {
			throw new RuntimeException(e);
		}
	}

}
