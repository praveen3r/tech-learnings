package com.demo.jasper;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class CorpUserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long serialNo;
	
	private String corpId;

	private String corpName;
	
	private String productCode;

	private String userName;
	
	private String userId;
	
	private String role;
	
	private Date createdDate;

	private List<CorpUserVO> corpUserList;
	
	public CorpUserVO(){
		
	}
	
	public CorpUserVO(String corpId,  String corpName, String productCode, String userId, String userName, String role, Date createdDate, Long serialNo) {
		this.corpId = corpId;
		this.corpName = corpName;
		this.productCode = productCode;
		this.userName = userName;
		this.userId = userId;
		this.role = role;
		this.createdDate = createdDate;
		this.serialNo = serialNo;
	}

	
	public Long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}



	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<CorpUserVO> getCorpUserList() {
		return corpUserList;
	}

	public void setCorpUserList(List<CorpUserVO> corpUserList) {
		this.corpUserList = corpUserList;
	}

	
	
	
	
}
