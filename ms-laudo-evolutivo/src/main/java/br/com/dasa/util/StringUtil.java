package br.com.dasa.util;

public abstract class StringUtil {

	static public String normalizeValue(String valueParam) {
		String value = "";

		if (valueParam != null && !valueParam.isEmpty()) {
			value = valueParam.replaceAll("[^\\.+^\\d+^,+]", "");
			value = value.replace(".", "").replaceAll(",", ".");
		}

		return value;
	}
	
	static public String replaseCommaToDot(String value) {
		if (value != null && !value.isEmpty()) {
			value = value.replace(".", "").replace(",", ".");
		}
		
		return value;
	}

}
