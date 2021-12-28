package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.DepartmentDto;
import com.demo.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/{userId}")
	public DepartmentDto getDepartment(@PathVariable("userId") final long userId) {
		return departmentService.getDepartment(userId);
	}
	

	
}
