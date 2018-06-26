package br.com.cea.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class PropertyUtil {

	private static Logger logger = LogManager.getLogger();

	final private static String PATH_CONFIG_FILE = "/DevEnvironment/sry_configs/config.properties";

	public static Properties getProperty(String path) throws IOException {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			File file = new File(path);

			if (file.exists() && !file.isDirectory()) {
				input = new FileInputStream(path);
				// load a properties file
				prop.load(input);
			} else {
				prop = null;
			}

		} catch (IOException ex) {
			logger.error(ex.getMessage());
			throw ex;
		} finally {
			if (input != null)
				input.close();
		}

		return prop;

	}

	public static String getConfigParamByKey(String key) {

		String config = "";
		Properties prop = null;

		try {
			prop = PropertyUtil.getProperty(new File(PATH_CONFIG_FILE).getCanonicalPath());
		} catch (IOException e) {
			logger.info("Arquivo de configuração inexistente, sistema em produção!");
		}

		if (prop != null) {
			config = prop.getProperty(key);
		}

		return config;
	}

}
