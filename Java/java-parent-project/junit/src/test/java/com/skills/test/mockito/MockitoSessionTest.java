package com.skills.test.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

import com.skills.junit.mockito.Arithmatic;

import junit.framework.TestCase;

public class MockitoSessionTest extends TestCase {

	@Mock
	Arithmatic arithmatic;
	
	MockitoSession mockito;
	
	@Before
	public void setUp(){
		System.out.println("setUp Method");
		mockito=Mockito.mockitoSession().initMocks(this).startMocking();
	}
	
	@Test
	public void testArithmatic(){
		when(arithmatic.add(anyInt(), anyInt())).thenReturn(2);
		System.out.println(arithmatic.add(1, 1));
		assertEquals("error",2,arithmatic.add(1, 1));
	}
	
	@After
	public void tearDown(){
		System.out.println("tearDown method");
		mockito.finishMocking();
	}
}
