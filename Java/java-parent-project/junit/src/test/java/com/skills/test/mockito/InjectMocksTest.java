package com.skills.test.mockito;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.skills.junit.mockito.Database;
import com.skills.junit.mockito.DatabaseByConstructor;
import com.skills.junit.mockito.DatabaseBySetter;
import com.skills.junit.mockito.DatabaseByVariable;

@RunWith(MockitoJUnitRunner.class)
public class InjectMocksTest {

	@Spy
	public Database db;
	
	@Spy
	public Database db1;
	
	@InjectMocks
	public DatabaseByConstructor dbConn;
	
	@InjectMocks
	public DatabaseBySetter dbConnSetter;
	
	@InjectMocks
	public DatabaseByVariable dbConnVar;
	
	@Test
	public void testDbConnection(){
		//when(db1.checkConnection()).thenReturn("Connected by Mock");
		System.out.println(dbConn.checkConnection());
		System.out.println("Tested");
	}
	
	//getter,setter and variable will do by type. If two or more fields are there with same type
	//then byName will be taken
	@Test
	public void testDbConnectionBySetter(){
		//when(db2.checkConnection()).thenReturn("Connected by Mock Setter");
		System.out.println(dbConnSetter.checkConnection());
		System.out.println("Tested");
	}
	
	@Test
	public void testDbConnectionByVariable(){
		//when(db.checkConnection()).thenReturn("Connected by Mock Variable");
		//when(dbConnVar.checkConnection1()).thenReturn("Mocked");
		//when(dbConnVar.TestingInjectMocks()).thenReturn("Mocked by Runner");
		//doReturn("Mocked by Runner").when(dbConnVar).TestingInjectMocks();
		System.out.println(dbConnVar.checkConnection1());
		System.out.println(dbConnVar.TestingInjectMocks());
		System.out.println("Tested");
	}
}
