package com.skills.test.basic;

import com.skills.junit.basic.Arithmatic;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyTest {
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before Class");
	}
	
	@Before
	public void before(){
		System.out.println("Before");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("After Class");
	}
	
	@After
	public void after(){
		System.out.println("After");
	}
	
	@Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        Arithmatic tester = new Arithmatic(); // MyClass is tested
        System.out.println("First method");
        // assert statements
        assertEquals("Error", 0, 0);
        assertEquals("10 x 0 must be 0",0, tester.multiply(10, 0));
        assertEquals("0 x 10 must be 0",0, tester.multiply(0, 10));
        assertEquals("0 x 0 must be 0",0, tester.multiply(0, 0));
    }
	
	@Test(expected=Exception.class)
	//@Ignore
    public void multiplicationOfNonZeroIntegersShouldNotReturnZero() throws Exception {
        Arithmatic tester = new Arithmatic(); // MyClass is tested
        System.out.println("Second Method");
        MyTest myTest=new MyTest();
        myTest.multiplicationOfZeroIntegersShouldReturnZero();
        // assert statements
        assertEquals("10 x 1 must be 0",10, tester.multiply(10, 1));
        assertEquals("2 x 10 must be 0",20, tester.multiply(2, 10));
        assertEquals("1 x 5 must be 0",5, tester.multiply(1, 5));
        throw new Exception();
    }
	
	
}
