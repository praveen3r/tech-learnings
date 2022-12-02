package com.demo.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.demo.entity.Auth;

public interface AuthRepository extends JpaRepository<Auth, BigInteger> {
	
	@Procedure(name = "authenticate", outputParameterName = "p_respCode")
	Integer authenticate(@Param("p_userId") String principal, @Param("p_credential") String credential);
	
}
