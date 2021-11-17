package com.demo.controller;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;

import com.demo.service.UserExternalService;

 

@RunWith(SpringJUnit4ClassRunner.class)
@RestClientTest(UserExternalService.class)
public class UserControllerRestClientTest {

	@Autowired
	UserExternalService userExternalService;
	
	private MockRestServiceServer mockServer;
	 
    @Before
    public void setUp() {
    	RestTemplate restTemplate = new RestTemplate();
        RestGatewaySupport gateway = new RestGatewaySupport();
        gateway.setRestTemplate(restTemplate);
        mockServer = MockRestServiceServer.createServer(gateway);
    }
    
    @Test
    public void testGetRootResourceOnce() {
       /* mockServer.expect(once(), requestTo("http://localhost:8080"))
            .andRespond(withSuccess("{message : 'under construction'}", MediaType.APPLICATION_JSON));*/
    	
    	mockServer.expect(once(), requestTo("http://localhost:8080/test23"))
        .andRespond(withSuccess("test", MediaType.TEXT_PLAIN));
    	
    	String externalServiceResponse = userExternalService.callExternal();
    	
        assertThat(externalServiceResponse,is("test"));
 
    }
}
