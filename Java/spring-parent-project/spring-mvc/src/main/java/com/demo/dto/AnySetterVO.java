package com.demo.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class AnySetterVO {

	 private Map<String, String> properties = new HashMap<String, String>();
	 
	    @JsonAnySetter
	    public void setProperties(String key, String value){
	        properties.put(key, value);
	    }

		public Map<String, String> getProperties() {
			return properties;
		}

}
