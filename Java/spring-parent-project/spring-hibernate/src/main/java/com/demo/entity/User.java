package com.demo.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name="USER_TABLE")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="KEYWORD")
	private String keyword;
	
	@Convert(converter=BooleanToStringConverter.class)
	private Boolean isLocked; 

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
