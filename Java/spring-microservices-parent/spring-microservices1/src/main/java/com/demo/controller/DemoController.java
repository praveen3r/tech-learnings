package com.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.CustomerAcct;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ms1")
public class DemoController {

	@RequestMapping(method = RequestMethod.GET, value="/rest1")
    public CustomerAcct rest1() {
		CustomerAcct customerAcct = new CustomerAcct();
		customerAcct.setAcctId("123");
		customerAcct.setCifId("SMITH");
		List<CustomerAcct> customerAcctList = Collections.singletonList(customerAcct);
		CustomerAcct customerAcct1 = new CustomerAcct();
		customerAcct1.setCustomerAcct(customerAcctList);
		return customerAcct1;
    }
	
	/*@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
			   @HystrixProperty(name = "fallback.enabled", value = "true"),
				@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
				@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "200")
			})
	@RequestMapping(method = RequestMethod.GET, value="/rest1")
 public CustomerAcct rest1() {
		System.out.println(1/0);
		CustomerAcct customerAcct = new CustomerAcct();
		customerAcct.setAcctId("123");
		customerAcct.setCifId("SMITH");
		List<CustomerAcct> customerAcctList = Collections.singletonList(customerAcct);
		CustomerAcct customerAcct1 = new CustomerAcct();
		customerAcct1.setCustomerAcct(customerAcctList);
		return customerAcct1;
 }*/

	private CustomerAcct fallback() {
		CustomerAcct customerAcct = new CustomerAcct();
		customerAcct.setAcctId("fallback123");
		customerAcct.setCifId("fallback");
		List<CustomerAcct> customerAcctList = Collections.singletonList(customerAcct);
		CustomerAcct customerAcct1 = new CustomerAcct();
		customerAcct1.setCustomerAcct(customerAcctList);
		return customerAcct1;
		}
}
