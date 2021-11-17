package com.wipro.campaign.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ATTEMPTS")
@Getter
@Setter
public class Attempts {

	@Id
	@SequenceGenerator(name = "ATTEMPT_SEQID", sequenceName = "ATTEMPT_SEQ_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTEMPT_SEQID")
	@Column(name = "ATTEMPT_ID")
	private Long answerId;
	
	@Column(name = "ATTEND_DATE")
	@Temporal(TemporalType.DATE)
	private Date attendDate;
	
	@Column(name = "EMAILID")
	private String emailId;
	
	@OneToMany(mappedBy = "attempt", cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Answer> answerList;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAMPAIGN_ID", nullable = false, updatable = false)
	private Campaign campaign;

}
