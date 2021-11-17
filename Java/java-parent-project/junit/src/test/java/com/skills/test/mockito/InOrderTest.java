package com.skills.test.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.skills.junit.mockito.Arithmatic;

public class InOrderTest {
	
	Arithmatic arithmatic;
	
	@Before
	public void before(){
		arithmatic=mock(Arithmatic.class);
	}
	
	@Test
	public void testArithmatic(){
		when(arithmatic.add(anyInt(), anyInt())).thenCallRealMethod();
		when(arithmatic.multiply(anyInt(), anyInt())).thenCallRealMethod();
		System.out.println(arithmatic.add(1, 2));
		System.out.println(arithmatic.multiply(1, 4));
		System.out.println(arithmatic.add(1, 2));
		InOrder inOrder=inOrder(arithmatic);
		
		inOrder.verify(arithmatic).multiply(anyInt(), anyInt());
		inOrder.verify(arithmatic).add(anyInt(), anyInt());
		
	}

}
