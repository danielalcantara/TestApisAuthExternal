package br.com.dasa.util;

public abstract class IntegerUtil {

	public static boolean isBlank(String value) {
		return (value == null || value.trim().isEmpty());
	}

	public static boolean isOnlyNumber(String value) {
		boolean ret = false;
		if (!isBlank(value)) {
			ret = value.matches("^[0-9]+$");
		}
		return ret;
	}

}
