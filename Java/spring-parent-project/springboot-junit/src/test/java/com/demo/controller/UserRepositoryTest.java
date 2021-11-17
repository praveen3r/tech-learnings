package com.demo.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.DemoApplication;
import com.demo.entity.User;
import com.demo.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class UserRepositoryTest {

	@Autowired
    private UserRepository repository;
	
	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		List<User> userList = repository.findAll();
		
	     assertEquals(userList.size(), 3);
	 }
}
