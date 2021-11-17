package com.demo.model;

import java.util.List;

public class CustomerAcct {

	private String acctId;
	
	private String cifId;
	
	private List<CustomerAcct> customerAcctList;

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getCifId() {
		return cifId;
	}

	public void setCifId(String cifId) {
		this.cifId = cifId;
	}

	public List<CustomerAcct> getCustomerAcctList() {
		return customerAcctList;
	}

	public void setCustomerAcct(List<CustomerAcct> customerAcctList) {
		this.customerAcctList = customerAcctList;
	}
}
