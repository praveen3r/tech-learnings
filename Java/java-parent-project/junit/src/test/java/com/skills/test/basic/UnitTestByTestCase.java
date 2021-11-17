package com.skills.test.basic;

import junit.framework.TestCase;

public class UnitTestByTestCase extends TestCase {

	public void setUp(){
		System.out.println("Before each method");
	}
	public void testAnyMethod(){
		System.out.println("Testing");
	}
	public void tearDown(){
		System.out.println("After each method");
	}
}
