package com.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TestHibernateAnnotation {

	@NotNull
    @Size(min = 1, max = 10)
    String name;
	
	@NotNull
    String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
