package com.skills.test.mockito;

import static org.mockito.AdditionalMatchers.lt;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.skills.junit.mockito.Arithmatic;


@RunWith(MockitoJUnitRunner.class)
public class BasicMockitoTest {

	@Mock
	Arithmatic arithmatic1;
	
	/*@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule(); */
	
	//Using mock how to mock the class
	@Test
	public void testAdd(){
		int a=1,b=1;
		Arithmatic arithmatic=mock(Arithmatic.class);
		when(arithmatic.add(anyInt(),lt(100))).thenAnswer(mockAdd1());
		System.out.println(arithmatic.add(1, 1));
		System.out.println(arithmatic.add(1, 1));
		System.out.println("Test addition");
	}
	
	public int mockAdd(){
		return 0;
	}

	public Answer<Integer> mockAdd1(){
		Answer ans=new Answer<Integer>(){
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Object[] args = invocation.getArguments();
			    return (Integer) args[0]+(Integer)args[1];
			}
		};
		return ans;
	}
	/*@Test
	public void testAdd1(){
		int a=1,b=1;
		when(arithmatic1.add(a,b)).thenAnswer(mockAdd1());
		//thenReturn(4).thenReturn(3);
		//To call void method
		//.thenAnswer(testVoid());
		System.out.println(arithmatic1.add(1, 1));
		System.out.println(arithmatic1.add(1, 1));
		System.out.println(arithmatic1.add(1, 1));
		System.out.println(arithmatic1.add(1, 1));
		verify(arithmatic1,times(4)).add(1,1);
		verifyNoMoreInteractions(arithmatic1);
		System.out.println("Test addition1");
	}
	
	Answer<Integer> testVoid(){
		System.out.println("From Void Method");
		return null;
	}
	
	@Test
	public void testLinkedListSpyWrong() {
	    // Lets mock a LinkedList
	    List<String> list = new LinkedList<String>();
	    List<String> spy = spy(list);

	    // this does not work
	    // real method is called so spy.get(0)
	    // throws IndexOutOfBoundsException (list is still empty)
	    //when(spy.get(0)).thenReturn("foo");
	    //Below one will work
	    doReturn("foo").when(spy).get(0);
	    assertEquals("foo", spy.get(0));
	}
	
	//Resetting the mock
	@Test
	public void testResetMockito(){
		Arithmatic arithmatic=mock(Arithmatic.class);
		when(arithmatic.add(anyInt(), anyInt())).thenReturn(2);
		System.out.println("Before Reset : "+arithmatic.add(1, 1));
		reset(arithmatic);
		System.out.println("After Reset : "+arithmatic.add(1, 1));
	}
*/}
