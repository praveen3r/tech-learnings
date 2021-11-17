package com.skills.test.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.internal.verification.AtLeast;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.VerificationCollector;

import com.skills.junit.mockito.Arithmatic;

public class VerifyTest {
	
	@Rule
	public VerificationCollector collector=MockitoJUnit.collector();

	@Test
	public void testArithmatic(){
		Arithmatic arithmatic=mock(Arithmatic.class);
		when(arithmatic.add(anyInt(), anyInt())).thenCallRealMethod();
		System.out.println(arithmatic.add(1, 1));
		System.out.println(arithmatic.addDefault());
		//It will verify add method called only once
		verify(arithmatic).add(1,1);
		verify(arithmatic,times(1)).add(anyInt(), anyInt());
		verify(arithmatic,atLeastOnce()).add(anyInt(), anyInt());
		verify(arithmatic,atMost(1)).add(anyInt(),anyInt());
		verify(arithmatic,never()).multiply(anyInt(),anyInt());
		verify(arithmatic,atLeast(0)).multiply(anyInt(), anyInt());
		verify(arithmatic,atMost(0)).multiply(anyInt(), anyInt());
		//verify(arithmatic,atMost(1)).addDefault();
		
		//This will verify only the above scenario happened for arithmatic object
		//It will throw error, if any method called and not verified
		//verifyNoMoreInteractions(arithmatic);
		
		
		//To verify no interactions happened
		//verifyZeroInteractions(arithmatic);
		
		//We should not place any method calls after verify calls
		//verifyZeroInteractions should be place on bottom after all method calls
		//And all the verify call, should be place before verifyNoMoreInteractions
		
		//collector.collectAndReport();
		//System.out.println(collector.toString());
		System.out.println("From Test Arithmatic");
	}
	
	@Test
	public void testNoMoreInteractions(){
		Arithmatic arithmatic=mock(Arithmatic.class);
		when(arithmatic.add(anyInt(), anyInt())).thenCallRealMethod();
		System.out.println(arithmatic.add(1, 1));
		verify(arithmatic).add(anyInt(), anyInt());
		verifyNoMoreInteractions(arithmatic);
	}
	
	@Test
	public void testZeroInteractions(){
		Arithmatic arithmatic=mock(Arithmatic.class);
		verifyZeroInteractions(arithmatic);
	}
	
	@Test
	public void testVerifyCollector(){
		//this method will use separate collector, when we use assertLazily
		VerificationCollector collector1=MockitoJUnit.collector().assertLazily();
		Arithmatic arithmatic=mock(Arithmatic.class);
		//System.out.println(arithmatic.add(1, 2));
		verify(arithmatic).add(anyInt(), anyInt());
		System.out.println("Before Verification");
		//collector1.collectAndReport();
		System.out.println("After verification");
	}
}
