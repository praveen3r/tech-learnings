package com.demo.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Department;
import com.demo.repository.DepartmentRepository;

@Service
public class DeparmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveData(){
		try{
			Department department = new Department();
			department.setId(new BigInteger("1"));
			department.setName("test");
			departmentRepository.save(department);
			System.out.println(2/0);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
