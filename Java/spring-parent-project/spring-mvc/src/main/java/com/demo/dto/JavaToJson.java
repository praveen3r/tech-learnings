package com.demo.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "id"})
@JsonRootName(value = "user")
public class JavaToJson {

	private String id;
	
	private String name;
	
	@JsonRawValue
	private String dept;
	
	 //@JsonSerialize(using = CustomDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	 public Date activeDate;

	//@JsonGetter(value = "new-id")
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

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
	
	/*@JsonValue
	public String jsonVal(){
		return "test";
	}*/
}
