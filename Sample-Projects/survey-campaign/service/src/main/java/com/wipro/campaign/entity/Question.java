package com.wipro.campaign.entity;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CAMPAIGN_QUESTION")
@Getter
@Setter
public class Question implements Persistable<Long>, Serializable
{

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "CAMPAIGN_QUES_SEQID", sequenceName = "CAMPAIGN_QUES_SEQ_ID", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPAIGN_QUES_SEQID")
   @Column(name = "QUESTION_ID")
   private Long questionId;

   @JsonIgnore
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "CAMPAIGN_ID", nullable = false, updatable = false)
   private Campaign campaign;

   @Column(name = "QUESTION")
   private String question;

   @Column(name = "ANSWER_TYPE")
   private String answerType;

   @Column(name = "FIELD_TYPE")
   private String fieldType;

   @Column(name = "CHOICE1")
   private String choice1;

   @Column(name = "CHOICE2")
   private String choice2;

   @Column(name = "CHOICE3")
   private String choice3;

   @Column(name = "CHOICE4")
   private String choice4;

   @Override
   public Long getId()
   {
      return null;
   }

   @Override
   public boolean isNew()
   {
      return true;
   }
}
