package com.wipro.campaign.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.campaign.entity.Attempts;
import com.wipro.campaign.entity.Campaign;
import com.wipro.campaign.services.AttemptsService;
import com.wipro.campaign.services.CampaignService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CampaignController
{

   @Autowired
   CampaignService campaignService;
   
   @Autowired
   AttemptsService attemptsService;

   @RequestMapping(value = "/campaigns", method = RequestMethod.GET)
   public Iterable<Campaign> getCampaigns()
   {
      List<Campaign> campaignList = new ArrayList<>();
      try
      {
         campaignList = campaignService.getCampaigns();
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
      }
      return campaignList;
   }
   
   @RequestMapping(value = "/getUserCampaigns/{id}", method = RequestMethod.GET)
   public ResponseEntity<List<Campaign>> getUserCampaigns(@PathVariable("id") String email)
   {
      List<Campaign> campaignList = new ArrayList<>();
      try
      {
         campaignList = campaignService.getCampaigns().stream()
        		 .filter(camp->{
        			 LocalDate endDate=LocalDate.parse(camp.getEndDate().toString(),DateTimeFormatter.ISO_DATE);
        			 LocalDate currentLocalDate=LocalDate.now().atStartOfDay().toLocalDate();
        			 return !endDate.isBefore(currentLocalDate);
        		 })
        		 .filter(campa->{
        			 return !campa.getAttemptList().stream().filter(att -> att.getEmailId().equalsIgnoreCase(email)).findFirst().isPresent();
        		 })
        		 .collect(Collectors.toList());
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         return new ResponseEntity<List<Campaign>>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<List<Campaign>>(campaignList,HttpStatus.OK);
   }
   
   @RequestMapping(value = "/getUserAttendedCampaigns/{id}", method = RequestMethod.GET)
   public ResponseEntity<List<Campaign>> getUserAttendedCampaigns(@PathVariable("id") String email)
   {
      List<Campaign> campaignList = new ArrayList<>();
      try
      {
         campaignList = campaignService.getCampaigns().stream()
        		 .filter(campa->{
        			 return campa.getAttemptList().stream().filter(att -> att.getEmailId().equalsIgnoreCase(email)).findFirst().isPresent();
        		 })
        		 .collect(Collectors.toList());
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         return new ResponseEntity<List<Campaign>>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<List<Campaign>>(campaignList,HttpStatus.OK);
   }
   
   @RequestMapping(value = "/campaign/{id}", method = RequestMethod.GET)
   public ResponseEntity<Campaign> getCampaign(@PathVariable("id") long campaignId)
   {
	   ResponseEntity<Campaign> response = null;
      Campaign campaign = new Campaign();
      try
      {
         Optional<Campaign> optcampaign = campaignService.getCampaigns().stream().filter(camp->camp.getCampaignId()==campaignId).findFirst();
         if(optcampaign.isPresent()){
        	 campaign = optcampaign.get();
        	 response = new ResponseEntity<Campaign>(campaign,HttpStatus.OK);
         } else {
        	 response = new ResponseEntity<Campaign>(HttpStatus.NOT_FOUND);
         }
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         response = new ResponseEntity<Campaign>(HttpStatus.NOT_FOUND);
      }
      return response;
   }

   @RequestMapping(value = "/campaign", method = RequestMethod.POST)
   public ResponseEntity<String> saveCampaign(@RequestBody final Campaign campaign)
   {
      ResponseEntity<String> response = null;
      try
      {
         campaignService.saveCampaign(campaign);
         response = new ResponseEntity<>(HttpStatus.OK);
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         response = new ResponseEntity<>("Error while processing", HttpStatus.NOT_FOUND);
      }
      return response;
   }

   @RequestMapping(value = "/campaigns/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<String> deleteCampaign(@PathVariable("id") final Long id)
   {
      ResponseEntity<String> response = null;
      try
      {
         campaignService.deleteCampaign(id);
         response = new ResponseEntity<>(HttpStatus.OK);
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         response = new ResponseEntity<>("Error while processing", HttpStatus.NOT_FOUND);
      }
      return response;
   }

   @RequestMapping(value = "/campaigns/{id}/questions/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<String> deleteQuestion(@PathVariable("id") final Long id)
   {
      ResponseEntity<String> response = null;
      try
      {
         campaignService.deleteQuestion(id);
         response = new ResponseEntity<>(HttpStatus.OK);
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         response = new ResponseEntity<>("Error while processing", HttpStatus.NOT_FOUND);
      }
      return response;
   }
   
   @RequestMapping(value = "/answers/{campaignId}", method = RequestMethod.POST)
   public ResponseEntity<String> saveAnswers(@PathVariable("campaignId") Long campaignId,@RequestBody final Attempts attempts)
   {
      ResponseEntity<String> response = null;
      try
      {
    	 Campaign campaign=campaignService.getCampaign(campaignId);
    	 if(Optional.ofNullable(campaign).isPresent()){
    		 attempts.setCampaign(campaign);
    		 attempts.setAttendDate(new Date());
    		 attemptsService.saveAttempts(attempts);
             response = new ResponseEntity<>(HttpStatus.OK);
    	 } else {
    		 response = new ResponseEntity<>("Error while processing", HttpStatus.NOT_FOUND);
    	 }
         
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         response = new ResponseEntity<>("Error while processing", HttpStatus.NOT_FOUND);
      }
      return response;
   }

}
