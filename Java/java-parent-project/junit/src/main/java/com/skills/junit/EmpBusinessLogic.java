package com.skills.junit;

public class EmpBusinessLogic {
	   // Calculate the yearly salary of employee
	   public double calculateYearlySalary(Employee employeeDetails) {
	      double yearlySalary = 0;
	      yearlySalary = employeeDetails.getMonthlySalary() * 12;
	      return yearlySalary;
	   }
		
	   // Calculate the appraisal amount of employee
	   public double calculateAppraisal(Employee employeeDetails) {
	      double appraisal = 0;
			
	      if(employeeDetails.getMonthlySalary() < 10000){
	         appraisal = 500;
	      }else{
	         appraisal = 1000;
	      }
			
	      return appraisal;
	   }
	   
	   public void exception(){
		   int a=1/0;
		   System.out.println(a);
	   }

}
