package br.com.cea.app;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.cea.config.BeanConfiguration;
import br.com.cea.processar.ProcessarPagamentoReport;

public class App {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = null;
		
		SpringApplication app = new SpringApplication(BeanConfiguration.class);
		ctx = app.run(args);
		
		ProcessarPagamentoReport cto = (ProcessarPagamentoReport) ctx.getBean(ProcessarPagamentoReport.class);
		cto.processar();
		
		System.exit(0);
	}

}
