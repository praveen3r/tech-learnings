package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.AcctDetails;

@RestController
@RequestMapping("/ms2")
public class DemoController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET, value="/rest1")
    public AcctDetails rest1(@RequestParam("acctId") String acctId) {
		AcctDetails acctDetails = new AcctDetails();
		acctDetails.setAcctId(acctId);
		acctDetails.setAcctType("SB");
		return acctDetails;
    }
	

	
}
