package com.demo.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

import com.demo.util.CommonUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "COURSE")
public class Course extends DefaultEntity implements Persistable<BigInteger>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "COURSE_SEQID", sequenceName = "COURSE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_SEQID")
	@Column(name = "ID")
	private BigInteger id;

	@Column(name = "NAME")
	private String name;

	/*
	 * @Column(name = "TYPE") private String type;
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE")
	private CourseTypeMaster courseTypeMaster;

	@Column(name = "AUTHOR")
	private String author;

	@Override
	public BigInteger getId() {
		return this.id;
	}

	@Override
	public boolean isNew() {
		return !CommonUtil.isNotEmpty(getId());
	}

}
