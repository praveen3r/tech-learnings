package com.skills.junit.mockito;

public class DatabaseBySetter {
	private Database db;
	private Database db1;
	
	public Database getDb() {
		return db;
	}

	public void setDb(Database db) {
		this.db = db;
	}

	public DatabaseBySetter() {
	}
	
	public String checkConnection(){
		return this.db.checkConnection()+" * "+db1.checkConnection();
	}

	public Database getDb1() {
		return db1;
	}

	public void setDb1(Database db1) {
		this.db1 = db1;
	}
}
