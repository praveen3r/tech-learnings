package com.wipro.campaign.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.campaign.entity.Answer;
import com.wipro.campaign.entity.Attempts;
import com.wipro.campaign.repository.AttemptsRepository;

@Service
public class AttemptsService {
	
	@Autowired
	AttemptsRepository attemptsRepository;
   
   public void saveAttempts(final Attempts attempts)
   {
	  final List<Answer> answerList = new ArrayList<>();
      attempts.getAnswerList().forEach(answer ->
      {
         answer.setAttempt(attempts);
         answerList.add(answer);
      });
      attempts.setAnswerList(answerList);
      attemptsRepository.save(attempts);
   }
}
