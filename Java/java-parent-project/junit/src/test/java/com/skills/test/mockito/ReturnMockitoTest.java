package com.skills.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import com.skills.junit.mockito.Arithmatic;
import com.skills.junit.mockito.EmployeeOps;
import com.skills.junit.mockito.EmployeeOpsInterface;

@RunWith(MockitoJUnitRunner.class)
public class ReturnMockitoTest {

	@Test
	public void test1()  {
	        //  create mock
	        Arithmatic test = mock(Arithmatic.class);

	        // define return value for method add()
	        when(test.add(anyInt(), anyInt())).thenReturn(2);

	        // use mock in test....
	        assertEquals(2,test.add(2,2));
	}


	// demonstrates the return of multiple values
	@Test
	public void testMoreThanOneReturnValue()  {
	        Iterator<String> i= mock(Iterator.class);
	        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
	        String result= i.next()+" "+i.next()+" "+i.next();
	        System.out.println(result);
	        //assert
	        assertEquals("Mockito rocks", result);
	}

	// this test demonstrates how to return values based on the input
	@Test
	public void testReturnValueDependentOnMethodParameter()  {
	        Comparable<String> c= mock(Comparable.class);
	        when(c.compareTo("Mockito")).thenReturn(1);
	        when(c.compareTo("Eclipse")).thenReturn(2);
	        //assert
	        assertEquals(1, c.compareTo("Mockito"));
	}

	// this test demonstrates how to return values independent of the input value

	@Test
	public void testReturnValueInDependentOnMethodParameter()  {
	        Comparable<Integer> c= mock(Comparable.class);
	        when(c.compareTo(anyInt())).thenReturn(-1);
	        //assert
	        assertEquals(-1, c.compareTo(9));
	}

	// return a value based on the type of the provide parameter

	@Test
	public void testReturnValueInDependentOnMethodParameter2()  {
	        Comparable<Arithmatic> c= mock(Comparable.class);
	        when(c.compareTo(isA(Arithmatic.class))).thenReturn(0);
	        //assert
	        assertEquals(0, c.compareTo(new Arithmatic()));
	}
	
	@Test
	public void testList(){
		List list=mock(ArrayList.class);
		when(list.get(0)).thenReturn(1);
		System.out.println(list.get(0));
	}
	
	//Mockito using annotation based
	@Mock
	Arithmatic arithmaticMock;
	
	/*@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();*/
	
	//calling real method
	@Test
	public void testAnnoatateMock(){
		when(arithmaticMock.add(anyInt(), anyInt())).thenCallRealMethod();
		//.thenReturn(2);
		assertEquals(3, arithmaticMock.add(1, 2));
	}
	
	//throw error using thenThrow
	//@Test(expected=IllegalArgumentException.class)
	@Test
	public void testThrowError(){
		when(arithmaticMock.add(anyInt(), anyInt())).thenReturn(3).thenThrow(IllegalArgumentException.class);
		int a=arithmaticMock.add(1, 1);
		assertEquals("Error from Throw",2,arithmaticMock.add(1, 1));
	}
	
	//We can mock abstract class also
	@Test
	public void testAbstract(){
		EmployeeOps empOps=mock(EmployeeOps.class);
		System.out.println(empOps.empName());
		System.out.println(empOps.calculateSalary());
	}
	
	//we can mock interface
	@Test
	public void testInterface(){
		EmployeeOpsInterface emploOps=mock(EmployeeOpsInterface.class);
		when(emploOps.calculateSalary()).thenReturn(2000);
		System.out.println("From Interface");
		System.out.println(emploOps.calculateSalary());
	}
	
	//we can mock final class also
	//
	@Test
	public void testFinal(){
		
	}
}
