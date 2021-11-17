package com.demo.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, BigInteger>{

}
