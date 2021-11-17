package com.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
	
	public static Logger logger = LoggerFactory.getLogger(TestLogger.class);

	public static void main(String[] args) {
		logger.debug("Log testing - DEBUG statement");
		logger.info("Log testing - INFO statement");
		logger.error("Log testing - ERROR statement");
		logger.warn("Log testing - WARN statement");

	}

}
