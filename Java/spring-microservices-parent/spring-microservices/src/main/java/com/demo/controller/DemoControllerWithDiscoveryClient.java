package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.AcctDetails;
import com.demo.model.CustomerAcct;

@RestController
@RequestMapping("/ms2")
public class DemoControllerWithDiscoveryClient {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET, value="/rest1")
    public AcctDetails rest1() {
		List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("MICROSERVICES-1");
		System.out.println(serviceInstanceList.get(0).getUri());
		AcctDetails acctDetails = null;
		CustomerAcct customerAcct = restTemplate.getForObject("http://microservices-1/ms1/rest1", CustomerAcct.class);
		for(CustomerAcct customerAcctObj:customerAcct.getCustomerAcctList()){
			Map<String, String> params = new HashMap<String, String>();
		    params.put("acctId", customerAcctObj.getAcctId());
		    acctDetails = restTemplate.getForObject("http://microservices-2/ms2/rest1?acctId={acctId}", AcctDetails.class,params);
		}
		return acctDetails;
    }
}
