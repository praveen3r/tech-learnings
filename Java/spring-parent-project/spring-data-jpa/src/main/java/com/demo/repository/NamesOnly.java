package com.demo.repository;

import org.springframework.beans.factory.annotation.Value;


public interface NamesOnly {

	String getUserName();
	String getPwd();
	
	@Value("#{target.userName + ' ' + target.pwd}")
	String getFullName();
	
	/*default String getFullName() {
    return getUserName().concat(" ").concat(getPwd());
  }*/
}
