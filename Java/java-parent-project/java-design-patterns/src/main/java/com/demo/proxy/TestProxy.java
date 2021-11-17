package com.demo.proxy;

public class TestProxy {

	/*
	 * used for access restriction
	 */
	public static void main(String[] args) {
		DatabaseExecutor databaseExecutor = new DatabaseExecutorImpl();
		databaseExecutor.executeQuery("select * from dual");
		
		DatabaseProxy databaseProxy = new DatabaseProxy("1","2",databaseExecutor);
		databaseProxy.executeQuery("select * from dual");
	}

}
