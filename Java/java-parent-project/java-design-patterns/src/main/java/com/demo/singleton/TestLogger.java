package com.demo.singleton;

public class TestLogger {

	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		Logger logger1 = Logger.getInstance();
		System.out.println("logger == logger1? " + (logger == logger1));
	}

}
