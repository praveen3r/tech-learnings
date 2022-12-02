package com.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DefaultEntity implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Column(name = "USER_ID")
   private BigInteger userId;

   @Column(name = "CRTD_DT", columnDefinition = "TIMESTAMP")
   private LocalDateTime localDateTime;
}
