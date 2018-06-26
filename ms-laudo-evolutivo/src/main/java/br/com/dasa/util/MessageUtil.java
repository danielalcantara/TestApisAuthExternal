package br.com.dasa.util;

import java.text.MessageFormat;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil implements IMessageUtil {

	@Autowired
	private MessageSource messageSource;

	private MessageSourceAccessor accessor;

	@PostConstruct
	private void init() {
		accessor = new MessageSourceAccessor(messageSource, new Locale("pt", "BR"));
	}

	public String getMessage(String code) {
		return accessor.getMessage(code);
	}

	public String getMessage(String code, Object... params) {
		return MessageFormat.format(accessor.getMessage(code), params);
	}

}
