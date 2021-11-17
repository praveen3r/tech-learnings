package com.demo.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.User;

@Transactional(readOnly = true)
public interface UserRepository4 extends JpaRepository<User, BigInteger>{

}
