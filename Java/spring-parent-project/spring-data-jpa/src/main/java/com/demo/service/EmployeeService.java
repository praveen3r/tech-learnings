package com.demo.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Department;
import com.demo.entity.Employee;
import com.demo.repository.DepartmentRepository;
import com.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DeparmentService deparmentService;
	
	@Transactional
	public void saveData(){
		try{
			Employee employee = new Employee();
			employee.setId(new BigInteger("1"));
			employee.setName("test");
			employeeRepository.save(employee);
			
			deparmentService.saveData();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
