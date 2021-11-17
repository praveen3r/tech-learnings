package com.demo.repository;

import java.util.List;

import com.demo.entity.User;

public interface UserRepositoryCustom {
	
	List<User> searchResults(User user) throws Exception;
	
}
