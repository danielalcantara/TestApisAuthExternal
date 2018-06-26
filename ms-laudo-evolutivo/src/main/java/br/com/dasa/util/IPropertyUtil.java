package br.com.dasa.util;

import java.io.IOException;
import java.util.Properties;

public interface IPropertyUtil {

	public Properties getProperty(String path) throws IOException;

	public String getConfigParamByKey(String key);

}
