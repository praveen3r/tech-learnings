package com.skills.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.skills.junit.mockito.Arithmatic;
import com.skills.junit.mockito.EmployeeOps;
import com.skills.junit.mockito.EmployeeOpsInterface;

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {
	
	@Spy
	EmployeeOps empOps;
	
	@Spy
	EmployeeOpsInterface empOps1;

	@Test
	public void test1()  {
	        //  create mock
	        Arithmatic test = spy(Arithmatic.class);

	        // use mock in test....
	        assertEquals(test.add(1,1), 2);
	}
	
	@Test
	public void testList(){
		List list=spy(ArrayList.class);
		//when(list.get(anyInt())).thenReturn(1);
		//use doReturn for this case
		doReturn(1).when(list).get(anyInt());
		System.out.println(list.get(0));
	}
	
	//spying abstract class
	@Test
	public void testEmployeeOps(){
		//Enabling the below line, will throw error
		//when(empOps.calculateSalary()).thenCallRealMethod();
		System.out.println(empOps.empName());
		System.out.println(empOps.calculateSalary());
	}
	
	//spying interface
	@Test
	public void testEmployeeOpsInterface(){
		when(empOps1.calculateSalary()).thenReturn(2000);
		System.out.println(empOps1.calculateSalary());
	}
}
