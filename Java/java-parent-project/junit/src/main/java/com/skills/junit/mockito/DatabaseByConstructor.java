package com.skills.junit.mockito;

public class DatabaseByConstructor {
	private Database db;
	private Database db1;

	public DatabaseByConstructor(Database db,Database db1) {
		this.db = db;
		this.db1 = db1;
	}
	
	public String checkConnection(){
		return this.db.checkConnection()+" - "+this.db1.checkConnection();
	}
}
