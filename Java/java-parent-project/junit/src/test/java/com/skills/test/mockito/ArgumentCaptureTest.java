package com.skills.test.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.MockitoJUnitRunner;

import com.skills.junit.mockito.Arithmatic;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentCaptureTest {
	
	Arithmatic arithmatic;
	
	//@Captor
	public ArgumentCaptor<Integer> captor=ArgumentCaptor.forClass(Integer.class);
	
	@Before
	public void before(){
		arithmatic=mock(Arithmatic.class);
	}
	
	@Test
	public void testArithmatic(){
		when(arithmatic.add(anyInt(), anyInt())).thenCallRealMethod();
		when(arithmatic.multiply(anyInt(), anyInt())).thenCallRealMethod();
		System.out.println(arithmatic.add(1, 3));
		System.out.println(arithmatic.add(2, 4));
		System.out.println(arithmatic.multiply(2, 4));
		verify(arithmatic,times(2)).add(captor.capture(),captor.capture());
		System.out.println(captor.getAllValues());
	}

}
