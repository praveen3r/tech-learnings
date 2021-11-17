package com.demo.repository;

import java.util.List;

import com.demo.entity.EmployeeResource;


public interface EmployeeResourceRepository {

	public void persistManyToMany();
	
	public List<EmployeeResource> getEmployeeResource();
	
}
