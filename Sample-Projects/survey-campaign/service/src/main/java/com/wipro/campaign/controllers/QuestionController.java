package com.wipro.campaign.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.campaign.entity.Question;
import com.wipro.campaign.services.QuestionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class QuestionController
{

   @Autowired
   QuestionService questionService;

   @RequestMapping(value = "/questions", method = RequestMethod.GET)
   public List<Question> getQuestions()
   {
      List<Question> questionList = new ArrayList<>();
      try
      {
         questionList = questionService.getQuestions();
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
      }
      return questionList;
   }

   @RequestMapping(value = "/question", method = RequestMethod.POST)
   public ResponseEntity<String> register(@RequestBody final Question question)
   {
      ResponseEntity<String> response = null;
      try
      {
         questionService.saveQuestion(question);
         response = new ResponseEntity<>(HttpStatus.OK);
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         response = new ResponseEntity<>("Error while processing", HttpStatus.NOT_FOUND);
      }
      return response;
   }

   @RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<String> register(@PathVariable("id") final Long id)
   {
      ResponseEntity<String> response = null;
      try
      {
         questionService.deleteQuestion(id);
         response = new ResponseEntity<>(HttpStatus.OK);
      }
      catch (final Exception e)
      {
         log.error("Error while registering user");
         response = new ResponseEntity<>("Error while processing", HttpStatus.NOT_FOUND);
      }
      return response;
   }

}
