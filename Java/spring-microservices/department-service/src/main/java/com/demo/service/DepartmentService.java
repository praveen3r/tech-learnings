package com.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.DepartmentDto;
import com.demo.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class DepartmentService {

	private static final Logger LOG = LogManager.getLogger(DepartmentService.class.getName());
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public DepartmentDto getDepartment(final long userId) {
		LOG.info("Inside zipkinService 2..");
		return departmentRepository.getDepartment(userId);
	}
}
