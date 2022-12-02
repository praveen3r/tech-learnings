package com.demo.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.dto.UserDto;
import com.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select new com.demo.dto.UserDto(usr.id, usr.firstName, usr.lastName, usr.email) from User usr JOIN usr.auth au WHERE au.userName = :p_userId")
	UserDto getUserDetails(@Param("p_userId") String userId);
	
	@Query("select usr.id from User usr JOIN usr.auth au WHERE au.userName = :p_userId")
	BigInteger getUserId(@Param("p_userId") String userId);
	
}
