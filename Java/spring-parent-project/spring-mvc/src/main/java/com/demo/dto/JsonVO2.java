package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;


public class JsonVO2 {

	private String id;
	
	private String name;
	
	private String dept;
	
	@JsonUnwrapped
	private JsonAddressVO address;

	public String getId() {
		return id;
	}

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
	
	public JsonAddressVO getAddress() {
		return address;
	}

	public void setAddress(JsonAddressVO address) {
		this.address = address;
	}
	
}
