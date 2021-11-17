package com.demo.proxy;

public class DatabaseProxy implements DatabaseExecutor{

	boolean isValidUser = false;
	DatabaseExecutor databaseExecutor;
	
	DatabaseProxy(String username, String pwd, DatabaseExecutor databaseExecutor){
		if(username.equals("1") && pwd.equals("1"))
			isValidUser = true;
		this.databaseExecutor = databaseExecutor;
	}
	
	@Override
	public void executeQuery(String query) {
		if(isValidUser)
			databaseExecutor.executeQuery(query);
		else
			System.out.println(" Ha ha, you are bad user. Better luck next time");
	}

}
