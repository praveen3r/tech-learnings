package com.skills.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@RequestMapping(method=RequestMethod.GET,path="/getEmployeeName")
	public String getEmployeeName(){
		return "Ragupathy";
	}
}
