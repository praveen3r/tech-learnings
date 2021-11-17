package com.demo.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, BigInteger>{

}
