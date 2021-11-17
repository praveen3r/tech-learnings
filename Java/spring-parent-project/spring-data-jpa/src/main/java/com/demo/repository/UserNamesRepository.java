package com.demo.repository;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.demo.entity.User;

public interface UserNamesRepository extends JpaRepository<User, BigInteger>,QueryByExampleExecutor<User>  {
	
	Collection<NamesOnly> findByUserName(String userName);
	

}
