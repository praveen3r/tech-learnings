package com.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_DATA")
public class CreditData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PAN_CARD")
	private String panCard;

	@Column(name = "CREDIT_SCORE")
	private Double creditScore;

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public Double getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Double creditScore) {
		this.creditScore = creditScore;
	}

}
