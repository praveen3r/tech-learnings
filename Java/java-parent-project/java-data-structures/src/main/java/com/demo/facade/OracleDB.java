package com.demo.facade;

public class OracleDB {
	
	public void getConnection() {
		System.out.println("got connection using oracle driver");
	}
	
	public void runQuery() {
		System.out.println("running query using oracle driver");
	}

}
