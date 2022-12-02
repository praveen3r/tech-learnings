package com.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="AUTH")
@Getter
@Setter
public class Auth implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="user")})
	private BigInteger id;
	
	@OneToOne()
	@PrimaryKeyJoinColumn
	private User user;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="CREDENTIAL")
	private String credential;
	
	@Column(name="INSTITUTION_ID")
	private Integer institutionId;
	
	@Column(name="FAIL_COUNT", insertable = false, updatable = false)
	private Integer failCount;
	
}
