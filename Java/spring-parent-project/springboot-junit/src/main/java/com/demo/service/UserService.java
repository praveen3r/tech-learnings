package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	/*public void getData(){
		Future<User> userFut = userRepository.findByUsername("test");
		User user = null;
		try {
			user = userFut.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(user);
	}*/
	
	public void getData(){
		List<User> user = null;
		try {
			user = userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(user!=null?user.get(0).getUserName():user);
	}
	
	/*public void getData1(){
		List<User> user = null;
		try {
			user = userRepository.findByUserNameAndPwd("test", "test");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(user!=null?user.get(0).getUserName():user);
	}
	
	public void getData2(){
		List<User> user = null;
		try {
			user = userRepository.findByAndSort("test", new Sort("userName"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(user!=null?user.get(0).getUserName():user);
	}*/
	
	
}
