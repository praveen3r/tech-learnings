package com.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity 
@Table(name="USER_DATA")
@Data
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private BigInteger id;
	
	@Column(name="USERNAME",nullable=false)
	private String userName;
	
	@Column(name="PASSWORD")
	private String pwd;
	
}
