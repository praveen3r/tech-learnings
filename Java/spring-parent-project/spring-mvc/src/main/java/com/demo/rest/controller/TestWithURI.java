package com.demo.rest.controller;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class TestWithURI {

	public static void main(String args[]){
		UriComponents uriComponents =
		        UriComponentsBuilder.newInstance()
		            .scheme("http").host("localhost:8080").path("/spring-mvc/test/version/{var1}/{var2}/{var3}").build()
		            .expand("1", "21","3")
		            .encode();
		System.out.println(uriComponents);
	}
}
