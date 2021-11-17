package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

//@JsonFilter("customFilter")
public class JsonVO3 {

	@JsonView(Views.Public.class)
	private String id;
	
	@JsonView(Views.Public.class)
	private String name;
	
	@JsonView(Views.Internal.class)
	private String dept;
	
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
