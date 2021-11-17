package com.wipro.campaign.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wipro.campaign.util.DateDeserializer;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CAMPAIGN")
@Getter
@Setter
public class Campaign implements Persistable<Long>, Serializable
{

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "CAMPAIGN_SEQID", sequenceName = "CAMPAIGN_SEQ_ID", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAMPAIGN_SEQID")
   @Column(name = "CAMPAIGN_ID")
   private Long campaignId;

   @Column(name = "TITLE")
   private String title;

   @Column(name = "START_DATE")
   @Temporal(TemporalType.DATE)
   private Date startDate;

   @Column(name = "END_DATE")
   @Temporal(TemporalType.DATE)
   @JsonDeserialize(using = DateDeserializer.class)
   private Date endDate;

   @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
   @OnDelete(action = OnDeleteAction.CASCADE)
   private List<Question> questionList;
   
   @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
   @OnDelete(action = OnDeleteAction.CASCADE)
   private List<Attempts> attemptList;

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
