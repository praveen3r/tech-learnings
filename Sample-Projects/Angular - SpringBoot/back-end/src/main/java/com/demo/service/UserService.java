package com.demo.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.UserDto;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public UserDto getUserDetails(String userId) {
		return userRepository.getUserDetails(userId);
	}
	
	public BigInteger getUserId(String userId) throws Exception {
		return userRepository.getUserId(userId);
	}
}
