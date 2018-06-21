package br.com.hubfintech.extauthtests.util;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

@Component
public class MessagesUtil implements IMessagesUtil {

	private static final String UNDEFINED_ERROR = "Undefined error.";

	@Inject
	MessageSource messages;

	@Inject
	LocaleResolver localeResolver;

	@Inject
	HttpServletRequest resquest;

	public String getMessage(String key, Object... objects) {
		String value = messages.getMessage(key, objects, UNDEFINED_ERROR, localeResolver.resolveLocale(resquest));
		return value;
	}

	@Override
	public String getMessage(String key) {
		String value = messages.getMessage(key, null, UNDEFINED_ERROR, localeResolver.resolveLocale(resquest));

		return value;
	}

}
