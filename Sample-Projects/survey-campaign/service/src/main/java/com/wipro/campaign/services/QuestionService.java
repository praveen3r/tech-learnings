package com.wipro.campaign.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.campaign.entity.Question;
import com.wipro.campaign.repository.QuestionRepository;

@Service
public class QuestionService
{

   @Autowired
   QuestionRepository questionRepository;

   public List<Question> getQuestions()
   {
      return (List<Question>) questionRepository.findAll();
   }

   public void saveQuestion(final Question question)
   {
      questionRepository.save(question);
   }

   public void deleteQuestion(final Long id)
   {
      questionRepository.deleteQuestion(id);
   }

}
