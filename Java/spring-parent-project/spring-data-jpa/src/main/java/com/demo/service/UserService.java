package com.demo.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.NamesOnly;
import com.demo.repository.UserNamesRepository;
import com.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	UserNamesRepository userNamesRepository;
	
	@Autowired
	AsyncService service;
	
	
	public void getDataWithAsync(){
		System.out.printf("calling async method from thread: %s%n",
                Thread.currentThread().getName());
		service.getName();
		Future<User> userFut = userRepository.findByUserName("test");
		List<User> userList = userRepository.findByIdGreaterThanEqual(BigInteger.ZERO);
		System.out.println(userList.size());
		List<User> userList1 = userRepository.findByIdGreaterThanEqual(BigInteger.ZERO);
		System.out.println(userList.size());
		User user = null;
		try {
			user = userFut.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(user);
		
	}
	
	public void getData(){
		List<User> user = null;
		try {
			user = userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(user!=null?user.get(0).getUserName():user);
	}
	
	public void getData1(){
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
	}
	
	public void executeQueries(){
		//userRepository.findByUserNameQueryHints("test");
		//userRepository.findByUserNameEntityGraph("test");
		Collection<NamesOnly> namesOnlyList = userNamesRepository.findByUserName("test");
		namesOnlyList.stream().forEach(names -> {
			System.out.println(names.getFullName());
		});
	}
	
	public void queryByExample(){
		User user = new User();
		user.setUserName("test");
		user.setPwd("test");
		
		//user.setPwd("st");
		
		//Example<User> userExample = Example.of(user);
		
		/*ExampleMatcher matcher = ExampleMatcher.matching()     
				  .withIgnorePaths("pwd")                         
				  .withIncludeNullValues()                             
				  .withStringMatcher(StringMatcher.ENDING);*/
		
		/*ExampleMatcher matcher = ExampleMatcher.matching()
				  .withMatcher("userName", new ExampleMatcher.GenericPropertyMatcher().endsWith())
				  .withMatcher("pwd", new ExampleMatcher.GenericPropertyMatcher().startsWith().ignoreCase());*/
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				  .withMatcher("firstname", match -> match.endsWith())
				  .withMatcher("firstname", match -> match.startsWith());
				
	
		Example<User> userExample = Example.of(user, matcher);
		
		userNamesRepository.findAll(userExample);
	}
}
