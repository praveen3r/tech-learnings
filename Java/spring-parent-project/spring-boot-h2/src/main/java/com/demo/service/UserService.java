package com.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@PostConstruct
	public void insertData() {
		User user = new User();
		//user.setId(1);
		user.setName("test");
		userRepository.save(user);
	}
}
