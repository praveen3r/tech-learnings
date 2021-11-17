package com.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.CustomerAcct;


@FeignClient("microservices-1")
public interface FeignClientService {

	@RequestMapping(method = RequestMethod.GET, value = "/ms1/rest1")
	CustomerAcct rest1();
}
