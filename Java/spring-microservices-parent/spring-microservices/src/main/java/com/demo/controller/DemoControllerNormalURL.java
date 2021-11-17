package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.AcctDetails;
import com.demo.model.CustomerAcct;

@RestController
@RequestMapping("/ms")
public class DemoControllerNormalURL {
	
	@Autowired
	RestTemplate restTemplate1;
	
	@RequestMapping(method = RequestMethod.GET, value="/rest1")
    public AcctDetails rest1() {
		AcctDetails acctDetails = null;
		CustomerAcct customerAcct = restTemplate1.getForObject("http://localhost:8082/ms1/rest1", CustomerAcct.class);
		for(CustomerAcct customerAcctObj:customerAcct.getCustomerAcctList()){
			Map<String, String> params = new HashMap<String, String>();
		    params.put("acctId", customerAcctObj.getAcctId());
		    acctDetails = restTemplate1.getForObject("http://localhost:8083/ms2/rest1?acctId={acctId}", AcctDetails.class,params);
		}
		return acctDetails;
    }
}
