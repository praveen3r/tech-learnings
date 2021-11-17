package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.CustomerAcct;
import com.demo.service.FeignClientService;

@RefreshScope
@RestController()
@RequestMapping("/feign")
public class DemoController {

	@Autowired
	FeignClientService feignClientService;
	

	@RequestMapping(method = RequestMethod.GET, value = "rest1")
   public CustomerAcct findme(){
      return feignClientService.rest1();
   }
}
