package com.skills.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import com.skills.junit.EmpBusinessLogic;
import com.skills.junit.Employee;

import junit.framework.TestCase;
import junit.framework.TestResult;
//To Ignore full 
//@Ignore
@RunWith(Parameterized.class)
public class TestEmployee {
	EmpBusinessLogic empBusinessLogic=new EmpBusinessLogic();
	Employee employee=new Employee();
	
	public TestEmployee(Employee employee){
		this.employee=employee;
	}
	
	@Parameters
	public static Collection employeeList() {
		Employee emp1=new Employee();
		emp1.setName("Rajeev");
	    emp1.setAge(25);
	    emp1.setMonthlySalary(8000);
	    Employee emp2=new Employee();
		emp2.setName("Rajee1");
	    emp2.setAge(23);
	    emp2.setMonthlySalary(7000);
	      return Arrays.asList(emp1,emp2);
	   }
	
	/*@BeforeClass
	public static void setEmp(){
		System.out.println("In Before Class");
	}
	
	
	public void tearDown(){
		System.out.println("In AfterClass");
	}*/
	@Before
	public void setUp(){
		/*employee.setName("Rajeev");
	    employee.setAge(25);
	    employee.setMonthlySalary(8000);*/
	}
	
	/*@After
	public void afterTestCases(){
		System.out.println("In After TestCase");
	}*/
	
	@Test
	@Ignore
	public void testCalculateAppriasal() {
	    System.out.println("In Calculate Appraisal");
	    double appraisal = empBusinessLogic.calculateAppraisal(employee);
	    assertEquals(500, appraisal, 0.0);
	 }
	
	@Test(expected=ArithmeticException.class)
	public void testException(){
		System.out.println("Inside Exception Test");
		empBusinessLogic.exception();
	}
	
	@Test
	public void testCalculateYearlySalary() {
		System.out.println("In Calculate Yearly Salary");
	    double salary = empBusinessLogic.calculateYearlySalary(employee);
	    System.out.println(salary);
	    assertEquals(96000, salary, 0.0);
	}

}
