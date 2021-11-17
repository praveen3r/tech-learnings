package com.demo.flyweight;

public class TestTester {

	public static void main(String[] args) {
		Employee employee = EmployeeFactory.getEmployee("dev");
		employee.assignSkill("Java");
		employee.task();
	}

}
