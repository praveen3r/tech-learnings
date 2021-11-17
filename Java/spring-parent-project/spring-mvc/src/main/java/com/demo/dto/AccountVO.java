package com.demo.dto;

public class AccountVO {

	private String accountNo;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public void clearValues(){
		this.accountNo = null;
	}
	
}
