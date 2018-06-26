package br.com.dasa.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

import br.com.dasa.util.IPropertyUtil;
import br.com.dasa.util.PropertyUtilByEnv;
import br.com.dasa.util.PropertyUtilByFile;

@Configuration
@PropertySource({ "classpath:config.properties" })
public class AppConf {

	private static Logger logger = LoggerFactory.getLogger(AppConf.class);

	@Autowired
	private Environment env;

	@Autowired
	IPropertyUtil propertyUtil;

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasenames("language/message", "language/errormsg");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public IPropertyUtil propertyUtil() {
		String envVariablesOrigin = env.getProperty("ENV_VARS_ORIGIN");
		String envVarsSysOrigin = env.getProperty("env.vars.system.origin");

		if (envVariablesOrigin != null && envVarsSysOrigin != null && envVariablesOrigin.equals(envVarsSysOrigin))
			return new PropertyUtilByEnv();
		else
			return new PropertyUtilByFile();

	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

		String environment = propertyUtil.getConfigParamByKey("ENVIRONMENT");
		String urlByFap = "";
		String urlByCip = "";

		switch (environment) {
		case "mock":
			urlByFap = propertyUtil.getConfigParamByKey("MS_ENDPOINT_FAP_MOCK");
			urlByCip = propertyUtil.getConfigParamByKey("MS_ENDPOINT_CIP_MOCK");
			break;
		case "desenv":
			urlByFap = propertyUtil.getConfigParamByKey("MS_ENDPOINT_FAP_DESENV");
			urlByCip = propertyUtil.getConfigParamByKey("MS_ENDPOINT_CIP_DESENV");
			break;
		case "homologacao":
			urlByFap = propertyUtil.getConfigParamByKey("MS_ENDPOINT_FAP_HOMOLOGACO");
			urlByCip = propertyUtil.getConfigParamByKey("MS_ENDPOINT_CIP_HOMOLOGACAO");
			break;
		case "prod":
			urlByFap = propertyUtil.getConfigParamByKey("MS_ENDPOINT_FAP_PROD");
			urlByCip = propertyUtil.getConfigParamByKey("MS_ENDPOINT_CIP_PROD");
			break;
		default:
			break;
		}

		logger.info("Url endpoint fap: " + urlByFap);
		logger.info("Url endpoint cip: " + urlByCip);

		logger.info("-----------------------------");
		logger.info("Environment: " + environment);

	}

}
