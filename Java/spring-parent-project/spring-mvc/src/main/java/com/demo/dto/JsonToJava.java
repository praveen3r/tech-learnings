package com.demo.dto;

import com.fasterxml.jackson.annotation.JacksonInject;


public class JsonToJava {

	private String id;
	
	@JacksonInject(value = "name")
	private String name;
	
	private String dept;

	public String getId() {
		return id;
	}

	//@JsonSetter("id12")
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	/*@JsonCreator
    public JsonToJava(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }*/
	
	
}
