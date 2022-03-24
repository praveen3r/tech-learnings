package com.demo.facade;

public class DatabaseHelper {

	public void runDB(String type) {
		if(type.equals("Oracle")) {
			OracleDB oracleDB = new OracleDB();
			oracleDB.getConnection();
			oracleDB.runQuery();
		}else {
			MongoDB mongoDB = new MongoDB();
			mongoDB.getConnection();
			mongoDB.runQuery();
		}
	}
}
