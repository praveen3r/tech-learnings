package com.demo.dto;

import java.io.Serializable;
import java.math.BigInteger;

import com.demo.validator.Required;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CourseDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private BigInteger id;
	
	@Required(fieldName = "name")
	private String name;
	
	@Required(fieldName = "type")
	private String type;
	
	@Required(fieldName = "author")
	private String author;
	
}
