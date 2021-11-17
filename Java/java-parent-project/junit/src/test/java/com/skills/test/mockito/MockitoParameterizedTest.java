package com.skills.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import com.skills.junit.mockito.Arithmatic;

@RunWith(Parameterized.class)
public class MockitoParameterizedTest {

	private int add1;
	private int add2;
	private int result;
	
	@Rule
	public MockitoRule rule=MockitoJUnit.rule();
	
	@Mock
	Arithmatic arithmatic;
	
	public MockitoParameterizedTest(int add1,int add2,int result){
		this.add1=add1;
		this.add2=add2;
		this.result=result;
	}
	
	@Parameters
	public static Collection<Object[]> setCollection(){
		Object[][] data = new Object[][] { { 1 , 2, 3 }, { 5, 3, 8 }, { 121, 4, 125 } };
        return Arrays.asList(data);
	}
	
	@Test
	public void testArithmatic(){
		when(arithmatic.add(anyInt(), anyInt())).thenCallRealMethod();
		assertEquals("Results are not matching",result, arithmatic.add(add1, add2));
		verify(arithmatic).add(anyInt(), anyInt());
	}
}
