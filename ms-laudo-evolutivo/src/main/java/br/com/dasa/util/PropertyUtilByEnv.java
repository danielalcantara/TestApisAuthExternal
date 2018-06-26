package br.com.dasa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class PropertyUtilByEnv extends PropertyUtilAbstract {

	@Autowired
	private Environment env;

	@Override
	public String getConfigParamByKey(String key) {

		return env.getProperty(key);

	}

}
