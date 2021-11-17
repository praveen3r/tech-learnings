package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

//@JsonIgnoreProperties({"id","name1"})
//@JsonAutoDetect(setterVisibility = Visibility.PUBLIC_ONLY)
public class JsonVO1 {

	//@JsonIgnore
	private String id;
	
	//@JsonProperty(value="name1")
	private String name;
	
	public String dept;

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
	
	
}
