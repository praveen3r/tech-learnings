package com.demo.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class NewUserVO {

	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private AddressVO address;
	
	private long mobileNo;
	
	private String sex;
	
	private List<String> sexList;
	
	private List<SexVO> sexObjList;
	
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public List<SexVO> getSexObjList() {
		return sexObjList;
	}

	public void setSexObjList(List<SexVO> sexObjList) {
		this.sexObjList = sexObjList;
	}
	
	
	
}
