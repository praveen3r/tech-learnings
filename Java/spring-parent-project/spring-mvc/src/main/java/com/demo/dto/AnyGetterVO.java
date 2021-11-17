package com.demo.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class AnyGetterVO {

	private Map<String, String> properties = new HashMap<String, String>();
	 
    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
