package com.skills.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.skills.junit.mockito.Arithmatic;

public class AnswerMockitoTest {

	@Test
	public void test1()  {
	        //  create mock
	        Arithmatic test = mock(Arithmatic.class);

	        // define answer value for method add()
	        //answer is using to do dynamic stubbing return value
	        when(test.add(anyInt(), anyInt())).thenAnswer(new Answer<Integer>(){

				public Integer answer(InvocationOnMock invocation) throws Throwable {
					// TODO Auto-generated method stub
					Object[] args=invocation.getArguments();
					return ((Integer)args[0]+(Integer)args[1]);
				}
	        	
	        });

	        // use mock in test....
	        assertEquals(test.add(1,1), 2);
	}
}
