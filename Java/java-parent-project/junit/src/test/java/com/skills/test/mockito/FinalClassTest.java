package com.skills.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.skills.junit.mockito.EmpFinal;

public class FinalClassTest {

	@Test
	public void testEmpFinal(){
		EmpFinal emp=new EmpFinal();
		EmpFinal empFinal=mock(EmpFinal.class);
		when(empFinal.empSalary()).thenReturn(2000);
		System.out.println(empFinal.empSalary());
		assertEquals(emp.empSalary(),empFinal.empSalary());
	}
}
