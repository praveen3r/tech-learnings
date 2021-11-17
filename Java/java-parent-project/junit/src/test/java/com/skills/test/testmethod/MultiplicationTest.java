package com.skills.test.testmethod;

import org.junit.Test;

import com.skills.junit.testmethod.Arithmatic;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest {

	@Test
	public void multiplicationShouldReturnTest(){
		System.out.println("Inside multiplication Test");
		Arithmatic arithmatic=new Arithmatic();
		assertEquals("2 * 10 should equals 20",20,arithmatic.multiply(2, 10));
	}
}
