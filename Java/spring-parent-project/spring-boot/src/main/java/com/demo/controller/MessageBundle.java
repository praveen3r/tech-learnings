package com.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageBundle {

	@Autowired
	private MessageSource messageSource;
	
	public String getMsg(String msgCode, String locale) {
	      return messageSource.getMessage(msgCode, null, new Locale(locale));
	   }
}
