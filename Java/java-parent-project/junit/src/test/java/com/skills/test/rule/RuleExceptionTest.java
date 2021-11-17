package com.skills.test.rule;

import static org.junit.Assert.assertEquals;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.skills.junit.rule.ThrowException;

public class RuleExceptionTest {

	@Rule
	public ExpectedException exception=ExpectedException.none();
	
	@Rule
	public MyCustomRule myRule = new MyCustomRule();
	
	@Before
	public void before(){
		System.out.println("Before Method");
	}
	
	@Test
	//@Test(expected=IllegalArgumentException.class)
	public void testExceptionA(){
		//exception and message both should match
		exception.expect(IllegalArgumentException.class);
		//exception.expectMessage("Negative value not allowed");
//		RuleExceptionTest ruleException= new RuleExceptionTest();
//		ruleException.testExceptionA();
		System.out.println("testExceptionA");
		ThrowException throwException=new ThrowException();
		assertEquals("Error",2,throwException.throwIllegalException(-1));
	}
	
	@Test
	@Ignore
	public void testExceptionB(){
		System.out.println("testExceptionB");
		//Always success count
		Assume.assumeTrue(false);
		System.out.println("Continue...");
		//To fail the test cases
		//fail();
		assertEquals(1, 1);
	}
}
