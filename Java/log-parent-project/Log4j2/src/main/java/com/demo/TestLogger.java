package com.demo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
	
	public static Logger logger = LogManager.getLogger(TestLogger.class);

	public static void main(String[] args) {
		logger.trace("Log testing - TRACE statement");
		logger.debug("Log testing - DEBUG statement");
		logger.info("Log testing - INFO statement");
		logger.error("Log testing - ERROR statement");
		logger.warn("Log testing - WARN statement");
		logger.fatal("Log testing - FATAL statement");
		logger.debug("Unwanted message to be filtered");
		logger.debug("Sensitive message password to be masked - test@gmail.com");
	}

}
