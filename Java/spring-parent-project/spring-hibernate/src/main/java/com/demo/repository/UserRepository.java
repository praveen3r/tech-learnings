package com.demo.repository;

import java.util.List;

import com.demo.entity.User;

public interface UserRepository {

	public List<User> getUsers();
	
	public List<User> getUsersWithNamedParam();
	
	public List<User> getUsersWithCriteria();
	
	public List<User> getUsersWithCriteriaProjection();
	
	public List<Object[]> getUsersWithCriteriaProjectionProps();
	
	public List<Object[]> getUsersWithCriteriaQueryByExample();
	
	public List<User> getUsersWithCriteriaCacheable();
	
}
