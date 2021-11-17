package com.skills.test.mockito;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import com.skills.junit.basic.Arithmatic;

public class PowerMockTest {

	@Test
	public void testArithmatic(){
		System.out.println("Test");
		Arithmatic arithmatic=mock(Arithmatic.class);
	}
}
