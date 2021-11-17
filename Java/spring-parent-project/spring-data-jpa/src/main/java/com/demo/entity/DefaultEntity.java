package com.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class DefaultEntity implements Serializable {
	
   private static final long serialVersionUID = 1L;

   @Column(name="CCEI_EFCTV_DATE")
   @Temporal(TemporalType.DATE)
   private Date effectiveDate;
   
   @Column(name="CRUD_VALUE")
   private String crudValue;
   
   
}
