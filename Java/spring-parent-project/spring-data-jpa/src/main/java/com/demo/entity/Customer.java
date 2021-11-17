package com.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CSTMR_CRS_EXTN_INTL")
public class Customer extends DefaultEntity implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "CSTMR_CRS_EXTN_INTL_SEQID", sequenceName = "CSTMR_CRS_EXTN_INTL_SEQ", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CSTMR_CRS_EXTN_INTL_SEQID")
   @Column(name = "CCEI_CRS_EXTN_IDFR")
   private BigInteger id;
   
   @Column(name="IP_IDFR")
   private BigInteger crsCustomerIdfr;
   

public BigInteger getId() {
	return id;
}

public void setId(BigInteger id) {
	this.id = id;
}

public BigInteger getCrsCustomerIdfr() {
	return crsCustomerIdfr;
}

public void setCrsCustomerIdfr(BigInteger crsCustomerIdfr) {
	this.crsCustomerIdfr = crsCustomerIdfr;
}

}
