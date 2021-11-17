package com.demo.singleton;

import java.io.Serializable;

public class Logger implements Serializable {

	private static final long serialVersionUID = 1L;

	private static volatile Logger logger;

	private Logger() {

	}

	public static Logger getInstance() {
		if (logger == null) {
			synchronized (Logger.class) {
				if (logger == null) {
					logger = new Logger();
				}
			}
		}

		return logger;
	}

	protected Object readResolve() {
		return logger;
	}
}
