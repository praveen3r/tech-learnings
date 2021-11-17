package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonCreatorVO {

	private String id;
	
	private String name;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@JsonCreator
    public JsonCreatorVO(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
