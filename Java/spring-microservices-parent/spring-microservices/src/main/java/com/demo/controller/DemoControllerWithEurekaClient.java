package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.AcctDetails;
import com.demo.model.CustomerAcct;
import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/ms1")
public class DemoControllerWithEurekaClient {
	
	@Autowired
	EurekaClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET, value="/rest1")
    public AcctDetails rest1() {
		/*List<InstanceInfo> serviceInstanceList = discoveryClient.getInstancesById("MICROSERVICES-1");
		System.out.println(serviceInstanceList.get(0).getHomePageUrl());
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("MICROSERVICES-1", false);
		System.out.println(instance.getHomePageUrl());*/
		
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
