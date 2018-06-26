package br.com.dasa.util;

public interface IMessageUtil {

	public String getMessage(String keyMsg);

	public String getMessage(String code, Object... params);

}
