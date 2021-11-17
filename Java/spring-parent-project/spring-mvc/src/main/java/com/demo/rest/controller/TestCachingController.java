package com.demo.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache/")
public class TestCachingController {

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<String> getVersions() {
		 return ResponseEntity.ok()
		           .body("success");
	}
}
