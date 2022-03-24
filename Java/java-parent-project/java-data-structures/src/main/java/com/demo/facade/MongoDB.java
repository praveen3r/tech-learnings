package com.demo.facade;

public class MongoDB {

	public void getConnection() {
		System.out.println("got connection using mongodb driver");
	}
	
	public void runQuery() {
		System.out.println("running query using mongodb driver");
	}
}
