package com.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.trace.InMemoryTraceRepository;

public class CustomTrace extends InMemoryTraceRepository {

    public CustomTrace() {
        super.setCapacity(200);
    }

    @Override
    public void add(Map<String, Object> map) {
    	HashMap<String, Object> map1 = new HashMap<String, Object>();
    	map1.put("test", "test");
        super.add(map1);
    }

}
