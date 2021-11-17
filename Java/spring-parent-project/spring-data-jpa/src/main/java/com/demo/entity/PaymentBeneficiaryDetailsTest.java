package com.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class PaymentBeneficiaryDetailsTest implements Serializable {

	private static final long serialVersionUID = 1L;

	private long rowNo;
	
	private Long benifRefId;
	
	private BigDecimal amount;

	public long getRowNo() {
		return rowNo;
	}

	public void setRowNo(long rowNo) {
		this.rowNo = rowNo;
	}

	public Long getBenifRefId() {
		return benifRefId;
	}

	public void setBenifRefId(Long benifRefId) {
		this.benifRefId = benifRefId;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	

}
