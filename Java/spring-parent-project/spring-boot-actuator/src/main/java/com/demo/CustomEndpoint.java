package com.demo;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class CustomEndpoint implements Endpoint{

    public String getId() {
        return "custom-endpoint";
    }

    public boolean isEnabled() {
        return true;
    }

    public boolean isSensitive() {
        return false;
    }

    public String invoke() {
        return "This is a custom end point for demo purpose";
    }
	
	
}
