package com.demo.proxy;

public class TestProxy {

	/*
	 * used for access restriction
	 */
	public static void main(String[] args) {
		
		DatabaseProxy databaseProxy = new DatabaseProxy("1","2");
		databaseProxy.executeQuery("select * from dual");
	}

}
