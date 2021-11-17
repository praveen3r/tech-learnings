package com.skills.junit.mockito;

public class DatabaseByVariable {
	public Database db;
	public Database db1;
	
	public String checkConnection1(){
		String var="";
		if(db!=null){
			var=db.checkConnection()+" -- ";	
		}
		return var;
	}
	
	public String TestingInjectMocks(){
		String var="Calling Real Method";
		return var;
	}
}
