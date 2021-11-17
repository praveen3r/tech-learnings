package com.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RestfulValidationVO {

	  private Long id;
	  
	  @NotNull
	  @Size(min=2, message="Name should have atleast 2 characters")
	  private String name;
	  
	  @NotNull
	  @Size(min=7, message="Passport should have atleast 2 characters")
	  private String passportNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
}
