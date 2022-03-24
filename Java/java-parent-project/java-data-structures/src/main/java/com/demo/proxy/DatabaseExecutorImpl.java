package com.demo.proxy;

public class DatabaseExecutorImpl implements DatabaseExecutor {

	@Override
	public void executeQuery(String query) {
		System.out.println("Executing the query");
	}

}
