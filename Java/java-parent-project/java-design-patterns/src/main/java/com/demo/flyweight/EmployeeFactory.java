package com.demo.flyweight;

public class EmployeeFactory {

	public static Employee getEmployee(String type) {
		Employee employee = null;
		if(type.equals("dev")) {
			employee = new Developer();
		}else {
			employee = new Tester();
		}
		return employee;
	}
}
