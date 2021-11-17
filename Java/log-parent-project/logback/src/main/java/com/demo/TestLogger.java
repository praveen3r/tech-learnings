package com.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
	
	public static Logger logger = LoggerFactory.getLogger(TestLogger.class);

	public static void main(String[] args) {
		logger.trace("Log testing - TRACE statement");
		logger.debug("Log testing - DEBUG statement");
		logger.info("Log testing - INFO statement");
		logger.error("Log testing - ERROR statement");
		logger.warn("Log testing - WARN statement");
		logger.debug("Unwanted message to be filtered");
		logger.debug("Sensitive message password to be masked - test@gmail.com");

	}

}
