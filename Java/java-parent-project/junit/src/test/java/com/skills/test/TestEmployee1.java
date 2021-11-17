package com.skills.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.skills.junit.EmpBusinessLogic;
import com.skills.junit.Employee;

import junit.framework.TestCase;

public class TestEmployee1 extends TestCase {
	EmpBusinessLogic empBusinessLogic=new EmpBusinessLogic();
	Employee employee=new Employee();
	
	@Test
	public void testCalculateAppriasal() {
		employee.setName("Rajeev");
	    employee.setAge(25);
	    employee.setMonthlySalary(8000);
	    System.out.println("In Calculate Appraisal1");
	    double appraisal = empBusinessLogic.calculateAppraisal(employee);
	    assertEquals(500, appraisal, 0.0);
	 }
}
