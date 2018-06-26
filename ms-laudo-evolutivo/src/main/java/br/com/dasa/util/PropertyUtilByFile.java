package br.com.dasa.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyUtilByFile extends PropertyUtilAbstract {

	private static Logger logger = LoggerFactory.getLogger(PropertyUtilByFile.class);

	final static private String sufixPathConfigFile = "/conf/config_ext.properties";

	private StringBuilder pathConfFileExt;

	public PropertyUtilByFile() {
		super();

		pathConfFileExt = new StringBuilder();
		pathConfFileExt.append(System.getProperty("user.dir")).append(sufixPathConfigFile);
	}

	@Override
	public String getConfigParamByKey(String key) {

		String config = "";
		Properties prop = null;

		try {
			prop = getProperty(new File(pathConfFileExt.toString()).getCanonicalPath());
		} catch (IOException e) {
			logger.info("Arquivo de configuração inexistente, favor verificar!");
		}

		if (prop != null) {
			config = prop.getProperty(key);
		}

		return config;

	}

}
