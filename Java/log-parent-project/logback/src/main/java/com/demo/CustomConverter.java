package com.demo;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class CustomConverter extends ClassicConverter{

	@Override
	public String convert(ILoggingEvent event) {
		return "Custom Converter";
	}

}
