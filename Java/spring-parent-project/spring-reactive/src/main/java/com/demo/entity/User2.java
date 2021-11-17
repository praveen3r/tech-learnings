/*package com.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="USER_DATA")
@NamedQuery(name = "User.findByUserNameNamedQuery",query = "select u from User u where u.userName = ?1")
public class User2 implements Serializable{

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private BigInteger id;
	
	@Column(name="USERNAME",nullable=false)
	private String userName;
	
	@Column(name="PASSWORD")
	private String pwd;
	
	public User2(){
	}
	
	public User2(String userName){
		this.userName = userName;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
*/