package com.demo.sampleprog.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortByEmployeeName {

	public static void main(String[] args) {
		Employee employee1 = new Employee();
		employee1.setFirstName("Shree");
		employee1.setLastName("Partha");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Praveen");
		employee2.setLastName("Rajan");
		
		Employee employee3 = new Employee();
		employee3.setFirstName("Shiva");
		employee3.setLastName("Kandasamy");
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		
		//Collections.sort(employeeList, Comparator.comparing(Employee::getFirstName));
		//List<Employee> employeeNewList = employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());
		List<Employee> employeeNewList = employeeList.stream().sorted(Comparator.comparing(Employee::getFirstName).reversed()).collect(Collectors.toList());
		
		employeeNewList.forEach(employee -> {
			System.out.println(employee.getFirstName() + " " + employee.getLastName());
		});

	}

}
