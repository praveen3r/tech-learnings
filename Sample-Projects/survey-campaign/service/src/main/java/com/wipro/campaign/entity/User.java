package com.wipro.campaign.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User
{

   @Id
   @GeneratedValue
   private int id;

   private String name;

   @Column(name = "EMAILID", unique = true)
   private String emailId;

   private String password;

   private String role;

   public String getName()
   {
      return name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public String getEmailId()
   {
      return emailId;
   }

   public void setEmailId(final String emailId)
   {
      this.emailId = emailId;
   }

   public String getPassword()
   {
      return password;
   }

   public void setPassword(final String password)
   {
      this.password = password;
   }

   public String getRole()
   {
      return role;
   }

   public void setRole(final String role)
   {
      this.role = role;
   }
}
