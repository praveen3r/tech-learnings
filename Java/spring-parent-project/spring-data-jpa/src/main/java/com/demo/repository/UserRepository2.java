package com.demo.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.User;

public interface UserRepository2 extends UserRepositoryBase<User, BigInteger>{

}
