package br.com.hubfintech.batch.liberarsaldo.listener;

import org.apache.log4j.Logger;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import br.com.hubfintech.batch.liberarsaldo.util.DateUtil;
import br.com.hubfintech.batch.liberarsaldo.util.RegisterCancellationsUtil;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = Logger.getLogger(JobExecutionListenerSupport.class);

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("**** Iniciando processamento do batch... ****");
		log.info("**** Data e hora inicialização: " + DateUtil.getCurrentDateAndHour() + " ****");

		super.beforeJob(jobExecution);
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("**** Batch Finalizado com Sucesso!!! *****");

			if (RegisterCancellationsUtil.process > 0) {
				log.info("**** Resumo dos registros processados: ****");
				log.info("**** Final Auth: " + RegisterCancellationsUtil.qtdFinalAuth + " ****");
				log.info("**** Undefined Auth: " + RegisterCancellationsUtil.qtdUndefinedAuth + " ****");
				log.info("**** Pre Auth: " + RegisterCancellationsUtil.qtdPreAuth + " ****");

				if (RegisterCancellationsUtil.qtdProcessErros > 0) {
					log.info("**** Registros processados com erro: " + RegisterCancellationsUtil.qtdProcessErros
							+ " ****");
				}

				log.info("**** Total de Registros processados: " + (RegisterCancellationsUtil.qtdFinalAuth
						+ RegisterCancellationsUtil.qtdUndefinedAuth + RegisterCancellationsUtil.qtdPreAuth) + " ****");
			} else {
				log.info("**** Não houve registros processados!!! ****");
			}

		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			log.info("**** Batch Finalizado com Falha, favor verificar log!!! *****");
		}

		log.info("**** Data e hora finalização: " + DateUtil.getCurrentDateAndHour() + " *****");
	}
}
