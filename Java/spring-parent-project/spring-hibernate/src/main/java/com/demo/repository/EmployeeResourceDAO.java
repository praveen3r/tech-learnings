package com.demo.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.demo.entity.EmployeeResource;
import com.demo.entity.Project;

@Repository
public class EmployeeResourceDAO extends BaseRepositoryDAO<EmployeeResource , Serializable> implements EmployeeResourceRepository{

	public void persistManyToMany(){
		Project project = new Project();
		project.setTitle("IM");
		Set<Project> projects = new HashSet<>();
		projects.add(project);
		
		EmployeeResource employeeResource = new EmployeeResource();
		employeeResource.setFirstName("Abdul");
		employeeResource.setLastName("Kalam");
		employeeResource.setProjects(projects);
		
		try {
			makePersistent(employeeResource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<EmployeeResource> getEmployeeResource(){
		List<EmployeeResource> employeeResourceList = new ArrayList<>();
		try {
			final StringBuffer hql = new StringBuffer("FROM EmployeeResource er join fetch er.projects");
			employeeResourceList = findByHQL(hql.toString());
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return employeeResourceList;
	}
}
