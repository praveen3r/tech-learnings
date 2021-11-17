package com.wipro.campaign.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ANSWER")
@Getter
@Setter
public class Answer {
	
	@Id
	@SequenceGenerator(name = "ANSWER_SEQID", sequenceName = "ANSWER_SEQ_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWER_SEQID")
	@Column(name = "ANSWER_ID")
	private Long answerId;
	
	@Column(name = "QUESTION_ID")
	private Long questionId;	
	
	@Column(name = "ANSWER")
	private String answer;
	
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ATTEMPT_ID", nullable = false, updatable = false)
    private Attempts attempt;
}
