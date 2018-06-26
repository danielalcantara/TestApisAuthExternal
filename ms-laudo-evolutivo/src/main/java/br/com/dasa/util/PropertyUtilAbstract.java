package br.com.dasa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PropertyUtilAbstract implements IPropertyUtil {

	private static Logger logger = LoggerFactory.getLogger(PropertyUtilAbstract.class);

	@Override
	public Properties getProperty(String path) throws IOException {

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

}
