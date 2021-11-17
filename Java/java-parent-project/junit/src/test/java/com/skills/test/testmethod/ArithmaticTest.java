package com.skills.test.testmethod;

import com.skills.junit.testmethod.Arithmatic;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;

public class ArithmaticTest {

	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before Class");
	}
	
	@Before
	public void before(){
		System.out.println("Before all methods");
	}
	
	@Test
	public void additionShouldReturnTest(){
		System.out.println("In addition Testing");
		Arithmatic arithmatic = new Arithmatic();
		assertEquals("2+3 should equal to 5",5,arithmatic.add(2,3));
	}
	
	//timeout exception
	@Test(timeout=1)
	public void additionShouldReturnValTest(){
		System.out.println("In addition Testing");
		Arithmatic arithmatic = new Arithmatic();
		assertEquals("2+3 should equal to 5",5,arithmatic.add(2,3));
	}
	
	@Test
	@Ignore
	public void additionShoulNotReturnTest(){
		Assume.assumeFalse("Ignored by assume",true);
		System.out.println("Ignore testing");
		Arithmatic arithmatic = new Arithmatic();
		assertEquals("2+3 should equal to 5",5,arithmatic.add(1,3));
	}
	
	@After
	public void after(){
		System.out.println("After all methods");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("After Class");
	}
}
