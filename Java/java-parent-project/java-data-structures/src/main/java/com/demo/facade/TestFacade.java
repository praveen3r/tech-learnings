package com.demo.facade;

public class TestFacade {

	public static void main(String[] args) {
		DatabaseHelper databaseHelper = new DatabaseHelper();
		databaseHelper.runDB("Oracle");
	}

}
