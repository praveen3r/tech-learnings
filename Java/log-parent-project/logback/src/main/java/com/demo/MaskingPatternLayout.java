package com.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class MaskingPatternLayout extends PatternLayout {
	/**
	 * Value with which the pattern is to be masked with
	 */

	public String mask;
	/**
	 * Regex pattern to be checked in the logs for masking
	 */

	public String patternsProperty;

	/**
	 * Performing masking if the regex pattern matches a value in the logs. Each
	 * log message will be split and checked for pattern matching
	 *
	 * 
	 @param event
	 *            log event
	 * 
	 @return a masked message if the regex pattern matches.
	 */

	@Override
    
	public String doLayout(ILoggingEvent event){
	        
	return (!StringUtils.isBlank(patternsProperty) && !StringUtils.isBlank(mask)) ?
	                Stream.of(event.getMessage().split("\\s+")).map(this::maskMessage).collect(Collectors.joining(" "))
	                : event.getMessage();
	    }

	/**
	 * Mask the word if the pattern matches else return the word as is
	 *
	 * 
	 @param event
	 *            a single word from the log message
	 * 
	 @return Masked word if the pattern matches else return the word as is
	 */

	private String maskMessage(String event){
        Pattern pattern = Pattern.compile(patternsProperty);
        Matcher matcher = pattern.matcher(event);
        return (matcher.matches()) ? IntStream.range(0, event.length()).mapToObj(count -> mask).collect(Collectors.joining()) :event;
    }

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getPatternsProperty() {
		return patternsProperty;
	}

	public void setPatternsProperty(String patternsProperty) {
		this.patternsProperty = patternsProperty;
	}
}
