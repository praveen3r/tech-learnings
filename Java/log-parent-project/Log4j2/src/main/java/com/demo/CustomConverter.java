package com.demo;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(name = "cust1", category = "Converter")
@ConverterKeys({"cust", "cust1"})
public class CustomConverter extends LogEventPatternConverter {

	private static final CustomConverter INSTANCE = new CustomConverter();
	
	private CustomConverter()
	{
	    this("cust1", "cust1"); // not sure why!
	}

	protected CustomConverter(String name, String style) {
	    super(name, style);
	}

	public static CustomConverter newInstance(final String[] options) {
	    return INSTANCE;
	}
	
	@Override
	public void format(LogEvent arg0, StringBuilder arg1) {
		 arg1.append("Custom");
		
	}

	

}
