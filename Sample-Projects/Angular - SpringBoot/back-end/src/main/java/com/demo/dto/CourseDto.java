package com.demo.dto;

import java.io.Serializable;
import java.math.BigInteger;

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
	
	private String name;
	
	private String type;
	
	private String author;
	
}
