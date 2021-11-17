package com.demo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.demo.entity.EmployeeResource;
import com.demo.entity.User;
import com.demo.repository.EmployeeResourceRepository;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Inject
	UserRepository userRepository;
	
	@Inject
	EmployeeResourceRepository employeeResourceRepository;
	
	public void getUsers(){
		List<User> userList = userRepository.getUsers();
		userList.stream().forEach(names -> {
			System.out.println(names.getUserName());
		});
	}
	
	public void getUsersWithNamedParam(){
		List<User> userList = userRepository.getUsersWithNamedParam();
		userList.stream().forEach(names -> {
			System.out.println(names.getUserName());
		});
	}
	
	public void getUsersWithCriteria(){
		List<User> userList = userRepository.getUsersWithCriteria();
		userList.stream().forEach(names -> {
			System.out.println(names.getUserName());
		});
	}
	
	public void getUsersWithCriteriaProjection(){
		List<User> userList = userRepository.getUsersWithCriteriaProjection();
		userList.stream().forEach(names -> {
			System.out.println(names.getUserName());
		});
	}
	
	public void getUsersWithCriteriaProjectionProps(){
		List<Object[]> userList = userRepository.getUsersWithCriteriaProjectionProps();
		userList.stream().forEach(obj -> {
			System.out.println(obj[0]);
		});
	}
	
	public void getUsersWithCriteriaQueryByExample(){
		List<Object[]> userList = userRepository.getUsersWithCriteriaQueryByExample();
		userList.stream().forEach(obj -> {
			System.out.println(obj[0]);
		});
	}
	
	public void getUsersWithCriteriaCacheable(){
		List<User> userList = userRepository.getUsersWithCriteriaCacheable();
		userRepository.getUsersWithCriteriaCacheable();
		userList.stream().forEach(names -> {
			System.out.println(names.getUserName());
		});
	}
	
	public void persistManyToMany(){
		employeeResourceRepository.persistManyToMany();
	}
	
	public void getEmployeeResource(){
		List<EmployeeResource> employeeResourceList = employeeResourceRepository.getEmployeeResource();
		employeeResourceList.forEach(employeeResource -> {
			System.out.println(employeeResource.getFirstName());
			employeeResource.getProjects().forEach(projects -> {
				System.out.println(projects.getTitle());
			});
		});
	}
	
}
