package br.com.cea.dao.logger;

import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import br.com.cea.util.StringUtil;

@Component
public class LoggerCustom implements ILoggerCustom {

	private static Logger logger = LogManager.getLogger();

	public void gerarLog(ReflectionLogger reflectionLogger) {

		if (reflectionLogger != null) {

			@SuppressWarnings("unchecked")
			Class<ReflectionLogger> clazz = (Class<ReflectionLogger>) reflectionLogger.getClass();

			for (Field atributo : clazz.getDeclaredFields()) {
				try {
					atributo.setAccessible(true);
					logger.info(atributo.getName() + StringUtil.espaco(atributo.getName())
							+ atributo.get(reflectionLogger));
				} catch (Exception e) {
					logger.error(e);
				}
			}

			logger.info("\n");

		}
	}

}
