package com.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.dto.UserDto;
import com.demo.dto.UserDto;

@Repository
public class UserRepository {

	public UserDto getUser(@PathVariable("userId") final long userId) {
		UserDto userDto = new UserDto();
		userDto.setUserAddress("testUserAddress");
		userDto.setUserId(userId);
		userDto.setUserName("testUserCode");
		return userDto;
	}
}
